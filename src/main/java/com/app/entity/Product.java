package com.app.entity;

import lombok.Data;
import java.sql.Timestamp;
@Data

public class Product {
    private Integer id;
    private Integer supplier_id;
    private Integer hotel_id;
    private Timestamp create_time;
    private Integer status;
    private Integer product_type;
    private Long permission_value;
    private String action_takers;
    private Long itinerary_id;
	private Timestamp package_cost_date;
	private String internal_name;
	private String package_details;
	private Integer currency;
	private String contact_person;
	private String additional_contacts;
	private Integer competitors;
	private Integer max_competitors;
	private Integer pc_product_id;
	private Integer competitor_number;
	private String tax_details;
    private String extra_contact_email;
    private Integer push_price_type;
    private Integer commision;
    private Boolean pay_at_hotel;
    private Boolean is_rm_product;
    private Boolean is_kt_price;
    private Boolean is_applicable_gst;
    private Boolean is_price_range_tax_plan;
    private Boolean is_applicable_gst_hex;
    private Boolean auto_sync;
    private Boolean auto_update;
}

