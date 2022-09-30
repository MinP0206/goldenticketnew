package com.example.goldenmovieticketnew.dtos;

import lombok.Data;

@Data
public class RoomDto {
    private String id;
    private String name;
    private int capacity;
    private double totalArea;
    private String imgURL;
    private BranchDto branch;
}
