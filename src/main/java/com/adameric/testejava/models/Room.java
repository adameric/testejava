package com.adameric.testejava.models;

import lombok.Data;

@Data
public class Room {

    private Long roomID;
    private String categoryName;
    private Price price;
}
