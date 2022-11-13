package com.example.goldenticketnew.dtos;

import lombok.Data;

@Data
public class RoomDto {
    private int id;
    private String name;
    private int capacity;
    private double totalArea;
    private String imgURL;
    private BranchDto branch;
}
