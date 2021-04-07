package com.app.helper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import com.app.entity.Product;
import com.app.entity.Room;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelExporter {

    static String[] HEADERs = { "id", "supplier_id", "hotel_id","create_time","status","product_type",
			  "permmision_value","action_takers","itinerary_id","package_cost_date","internal_name","package_details",
			  "currency","contact_person","additional_contacts","competitors","max_competitors","pc_product_id",
			  "competitor_number","tax_details","extra_contact_email","push_price_type","commision","pay_at_hotel",
			  "is_rs_product","is_kt_price","is_applicable_gst","is_price_range_tax_plan","is_applicable_gst_hex", "auto_sync","auto_update"
            /*Room*/ ,"product_id","id","name","create_time","status","cool_type","image","description","extra_details","extra_room_details",
			"total_no_of_rooms","image_type","product_image","is_showondeal","is_dormroom","is_day_use","codex_room_id"
    
    
    };
    static String SHEET = "product";


	public static ByteArrayInputStream productToExcel(List object) {

        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet(SHEET);

			Product product = new Product();
			Room room = new Room();
            // Header
            Row headerRow = sheet.createRow(0);

            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }

            int rowIdx = 1;
          //itterating object using for each loop
            for (Object obj : object) {
				Row row = sheet.createRow(rowIdx++);
				if (obj.equals(product)) {
					//type casting object to product
					product = (Product) obj;

					if (product.getId() != null) row.createCell(0).setCellValue(product.getId());
					else row.createCell(0).setCellValue("");

					if (product.getSupplier_id() != null) row.createCell(1).setCellValue(product.getSupplier_id());
					else row.createCell(1).setCellValue("");

					if (product.getHotel_id() != null) row.createCell(2).setCellValue(product.getHotel_id());
					else row.createCell(2).setCellValue("");

					if (product.getCreate_time() != null) row.createCell(3).setCellValue(product.getCreate_time());
					else row.createCell(3).setCellValue("");

					if (product.getStatus() != null) row.createCell(4).setCellValue(product.getStatus());
					else row.createCell(4).setCellValue("");

					if (product.getProduct_type() != null) row.createCell(5).setCellValue(product.getProduct_type());
					else row.createCell(5).setCellValue("");

					if (product.getPermission_value() != null)
						row.createCell(6).setCellValue(product.getPermission_value());
					else row.createCell(6).setCellValue("");

					if (product.getAction_takers() != null) row.createCell(7).setCellValue(product.getAction_takers());
					else row.createCell(7).setCellValue("");

					if (product.getItinerary_id() != null) row.createCell(8).setCellValue(product.getItinerary_id());
					else row.createCell(8).setCellValue("");

					if (product.getPackage_cost_date() != null)
						row.createCell(9).setCellValue(product.getPackage_cost_date());
					else row.createCell(9).setCellValue("");

					if (product.getInternal_name() != null) row.createCell(10).setCellValue(product.getInternal_name());
					else row.createCell(10).setCellValue("");

					if (product.getPackage_details() != null)
						row.createCell(11).setCellValue(product.getPackage_details());
					else row.createCell(11).setCellValue("");

					if (product.getCurrency() != null) row.createCell(12).setCellValue(product.getCurrency());
					else row.createCell(12).setCellValue("");

					if (product.getContact_person() != null)
						row.createCell(13).setCellValue(product.getContact_person());
					else row.createCell(13).setCellValue("");

					if (product.getAdditional_contacts() != null)
						row.createCell(14).setCellValue(product.getAdditional_contacts());
					else row.createCell(14).setCellValue("");

					if (product.getCompetitors() != null) row.createCell(15).setCellValue(product.getCompetitors());
					else row.createCell(15).setCellValue("");

					if (product.getMax_competitors() != null)
						row.createCell(16).setCellValue(product.getMax_competitors());
					else row.createCell(16).setCellValue("");

					if (product.getPc_product_id() != null) row.createCell(17).setCellValue(product.getPc_product_id());
					else row.createCell(17).setCellValue("");

					if (product.getCompetitor_number() != null)
						row.createCell(18).setCellValue(product.getCompetitor_number());
					else row.createCell(18).setCellValue("");

					if (product.getTax_details() != null) row.createCell(19).setCellValue(product.getTax_details());
					else row.createCell(19).setCellValue("");

					if (product.getExtra_contact_email() != null)
						row.createCell(20).setCellValue(product.getExtra_contact_email());
					else row.createCell(20).setCellValue("");

					if (product.getPush_price_type() != null)
						row.createCell(21).setCellValue(product.getPush_price_type());
					else row.createCell(21).setCellValue("");

					if (product.getCommision() != null) row.createCell(22).setCellValue(product.getCommision());
					else row.createCell(22).setCellValue("");

					if (product.getPay_at_hotel() != null) row.createCell(23).setCellValue(product.getPay_at_hotel());
					else row.createCell(23).setCellValue("");

					if (product.getIs_rm_product() != null) row.createCell(24).setCellValue(product.getIs_rm_product());
					else row.createCell(24).setCellValue("");

					if (product.getIs_kt_price() != null) row.createCell(25).setCellValue(product.getIs_kt_price());
					else row.createCell(25).setCellValue("");

					if (product.getIs_applicable_gst() != null)
						row.createCell(26).setCellValue(product.getIs_applicable_gst());
					else row.createCell(26).setCellValue("");

					if (product.getIs_price_range_tax_plan() != null)
						row.createCell(27).setCellValue(product.getIs_price_range_tax_plan());
					else row.createCell(27).setCellValue("");

					if (product.getIs_applicable_gst_hex() != null)
						row.createCell(28).setCellValue(product.getIs_applicable_gst_hex());
					else row.createCell(28).setCellValue("");

					if (product.getAuto_sync() != null) row.createCell(29).setCellValue(product.getAuto_sync());
					else row.createCell(29).setCellValue("");

					if (product.getAuto_update() != null) row.createCell(30).setCellValue(product.getAuto_update());
					else row.createCell(30).setCellValue("");
				}
				//Room Details
				else if (obj.equals(room)) {
					//type casting object to room
					room=(Room)obj;
					System.out.println("Room list data :: "+room);
					if (room.getProduct_id() != null) row.createCell(31).setCellValue(room.getProduct_id());
					else row.createCell(31).setCellValue("");

					if (room.getId() != null) row.createCell(32).setCellValue(room.getId());
					else row.createCell(32).setCellValue("");

					if (room.getName() != null) row.createCell(33).setCellValue(room.getName());
					else row.createCell(33).setCellValue("");

					if (room.getCreate_time() != null) row.createCell(34).setCellValue(room.getCreate_time());
					else row.createCell(35).setCellValue(35);

					if (room.getStatus() != null) row.createCell(36).setCellValue(room.getStatus());
					else row.createCell(36).setCellValue("");

					if (room.getCool_type() != null) row.createCell(37).setCellValue(room.getCool_type());
					else row.createCell(37).setCellValue("");

					if (room.getImage() != null) row.createCell(38).setCellValue(room.getImage());
					else row.createCell(38).setCellValue("");

					if (room.getDescription() != null) row.createCell(39).setCellValue(room.getDescription());
					else row.createCell(39).setCellValue("");

					if (room.getExtraDetails() != null) row.createCell(40).setCellValue(room.getExtraDetails());
					else row.createCell(40).setCellValue("");

					if (room.getExtraRoomDetails() != null) row.createCell(41).setCellValue(room.getExtraRoomDetails());
					else row.createCell(41).setCellValue("");

					if (room.getTotalNoOfRooms() != null) row.createCell(42).setCellValue(room.getTotalNoOfRooms());
					else row.createCell(42).setCellValue("");

					if (room.getImage_type() != null) row.createCell(43).setCellValue(room.getImage_type());
					else row.createCell(43).setCellValue("");

					if (room.getProduct_image() != null) row.createCell(44).setCellValue(room.getProduct_image());
					else row.createCell(44).setCellValue("");

					if (room.getIs_showOnDeal() != null) row.createCell(45).setCellValue(room.getIs_showOnDeal());
					else row.createCell(45).setCellValue("");

					if (room.getIs_dormRoom() != null) row.createCell(46).setCellValue(room.getIs_dormRoom());
					else row.createCell(46).setCellValue("");

					if (room.getIs_day_use() != null) row.createCell(47).setCellValue(room.getIs_day_use());
					else row.createCell(47).setCellValue("");

					if (room.getCodex_room_id() != null) row.createCell(48).setCellValue(room.getCodex_room_id());
					else row.createCell(48).setCellValue("");
				}
			}
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }

}