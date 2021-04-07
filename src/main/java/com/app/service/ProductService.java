package com.app.service;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import com.app.entity.Room;
import com.app.helper.ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.app.entity.Product;

@Component
public class ProductService {
	@Autowired
	JdbcTemplate jdbcTemplate1;
	@Autowired
	JdbcTemplate jdbcTemplate2;

	RowMapper<Product> rowMapper1=(rs, rowNum)->{

		Product product=new Product();
		product.setId(rs.getInt("id"));
		product.setSupplier_id(rs.getInt("supplier_id"));
		product.setHotel_id(rs.getInt("hotel_id"));
		product.setCreate_time(rs.getTimestamp("create_time"));
		product.setStatus(rs.getInt("status"));
		product.setProduct_type(rs.getInt("product_type"));
		product.setPermission_value(rs.getLong("permission_value"));
		product.setAction_takers(rs.getString("action_takers"));
		product.setItinerary_id(rs.getLong("itinerary_id"));
		product.setPackage_cost_date(rs.getTimestamp("package_cost_date"));
		product.setInternal_name(rs.getString("internal_name"));
		product.setPackage_details(rs.getString("package_details"));
		product.setCurrency(rs.getInt("currency"));
		product.setContact_person(rs.getString("contact_person"));
		product.setAdditional_contacts(rs.getString("additional_contacts"));
		product.setCompetitors(rs.getInt("competitors"));
		product.setMax_competitors(rs.getInt("max_competitors"));
		product.setPc_product_id(rs.getInt("pc_product_id"));
		product.setCompetitor_number(rs.getInt("competitor_number"));
		product.setTax_details(rs.getString("tax_details"));
		product.setExtra_contact_email(rs.getString("extra_contact_email"));
		product.setPush_price_type(rs.getInt("push_price_type"));
		product.setCommision(rs.getInt("commision"));
		product.setPay_at_hotel(rs.getBoolean("pay_at_hotel"));
		product.setIs_rm_product(rs.getBoolean("is_rm_product"));
		product.setIs_kt_price(rs.getBoolean("is_kt_price"));
		product.setIs_applicable_gst(rs.getBoolean("is_applicable_gst"));
		product.setIs_price_range_tax_plan(rs.getBoolean("is_price_range_tax_plan"));
		product.setIs_applicable_gst_hex(rs.getBoolean("is_applicable_gst_hex"));
		product.setAuto_sync(rs.getBoolean("auto_sync"));
		product.setAuto_update(rs.getBoolean("auto_update"));
		return product;
	};

	RowMapper rowMapper2=(rs,rowNum)->{
		Room room=new Room();
		room.setProduct_id(rs.getInt("product_id"));
		room.setId(rs.getInt("id"));
		room.setName(rs.getString("name"));
		room.setCreate_time(rs.getTimestamp("create_time"));
		room.setStatus(rs.getInt("status"));
		room.setCool_type(rs.getInt("cool_type"));
		room.setImage(rs.getString("image"));
		room.setDescription(rs.getString("description"));
		room.setExtraDetails(rs.getString("extraDetails"));
		room.setExtraRoomDetails(rs.getString("extraRoomDetails"));
		room.setTotalNoOfRooms(rs.getInt("totalNoOfRooms"));
		room.setImage_type(rs.getString("image_type"));
		room.setProduct_image(rs.getString("product_image"));
		room.setIs_showOnDeal(rs.getString("is_showOnDeal"));
		room.setIs_dormRoom(rs.getString("is_dormRoom"));
		room.setIs_day_use(rs.getString("is_day_use"));
		room.setCodex_room_id(rs.getString("codex_room_id"));
		return room;
	};
	public  List /*ByteArrayInputStream*/ findAll(){
		 String query1="select * from product";

		 List products=jdbcTemplate1.query(query1,rowMapper1);

		 String query2="select * from room";
		 List rooms=jdbcTemplate2.query(query2,rowMapper2);

		 List listAll= (List) Stream.concat(products.stream(),rooms.stream()).collect(Collectors.toList());
		 return listAll;
		/*ByteArrayInputStream bis= ExcelExporter.productToExcel(products);
		return bis;*/
	}
}
