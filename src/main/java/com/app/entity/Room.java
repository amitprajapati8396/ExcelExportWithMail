package com.app.entity;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class Room {
    private Integer product_id;
    private Integer id;
    private String name;
    private Timestamp create_time;
    private Integer status;
    private Integer cool_type;
    private String image;
    private String description;
    private String extraDetails;
    private String extraRoomDetails;
    private Integer totalNoOfRooms;
    private String image_type;
    private String product_image;
    private String is_showOnDeal;
    private String is_dormRoom;
    private String is_day_use;
    private String codex_room_id;
}
