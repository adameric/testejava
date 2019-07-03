package com.adameric.testejava.models;

import lombok.Data;

import java.util.List;

@Data
public class Hotel {

    private Long id;
    private String name;
    private Long cityCode;
    private String cityName;
    private List<Room> rooms;

}
