package com.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private Integer port;
    @Value("${spring.mail.username}")
    private String username;
    @Value("${spring.mail.password}")
    private String password;

    @Bean
    public JavaMailSenderImpl javaMailService() {
        JavaMailSenderImpl impl=new JavaMailSenderImpl();
        impl.setHost(host);
        impl.setPort(port);
        impl.setUsername(username);
        impl.setPassword(password);
        impl.setJavaMailProperties(javaMailProperties());
        return impl;
    }
    public Properties javaMailProperties(){
        Properties prop=new Properties();
        prop.setProperty("mail.transport.protocol","smtp");
        prop.setProperty("mail.smtp.auth","true");
        prop.setProperty("mail.smtp.starttls.enable","true");
        prop.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        prop.setProperty("mail.debug","true");
        return prop;
    }
}
