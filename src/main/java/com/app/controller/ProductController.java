package com.app.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.activation.DataSource;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import javax.servlet.http.HttpServletResponse;

import com.app.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Email;
import com.app.helper.ExcelExporter;
import com.app.service.ProductService;

@RestController
public class ProductController{
	@Autowired
	private ProductService service;
	@Autowired
	private JavaMailSender mailSender;
	
	/*@GetMapping("/download")
    public ResponseEntity<?> exportToExcel() throws IOException {
        String filename = "product.xlsx";
        System.out.println(service.findAll());
        InputStreamResource file = new InputStreamResource(service.findAll());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }*/
	   
	/* RESTApi for send mail of user excel sheet to given email id
    *
    */

   @PostMapping(path="/send-mail",produces=MediaType.APPLICATION_ATOM_XML_VALUE)
   public ResponseEntity<?> sendMail(@RequestBody Email email , HttpServletResponse response){
       response.setContentType("application/octet-stream");
       String header="Content-Disposition";
       //headerValue
       String filename="product.xlsx";
       HttpHeaders headers=new HttpHeaders();

       headers. add(header,"attachment; filename=" + filename);
       response.setHeader(header,filename);
       //get byte from data
       ByteArrayInputStream bis= ExcelExporter.productToExcel(service.findAll());
       //calling send mail method
       sendMail(bis,email);

       return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_XML)
               .body(new InputStreamResource(bis));
   }
   //method for send mail for selected User
   private void sendMail(ByteArrayInputStream bis, Email email){
       final String emailToRecipient=email.getTo();
       final String emailSubject=email.getSubject();
       final String emailMessage=email.getMessage();
       mailSender.send(new MimeMessagePreparator() {

           @Override
           public void prepare(MimeMessage mimeMessage) throws Exception {
               MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
               helper.setTo(emailToRecipient);
               helper.setSubject(emailSubject);
               helper.setText(emailMessage,true);
               DataSource attachment=new ByteArrayDataSource(bis,"application/xlsx");
               helper.addAttachment("product.xlsx",attachment);
           }

       });
   }
}
