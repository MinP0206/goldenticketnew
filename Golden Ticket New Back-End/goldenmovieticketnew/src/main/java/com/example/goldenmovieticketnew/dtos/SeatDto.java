package com.example.goldenmovieticketnew.dtos;

import lombok.Data;

@Data
public class SeatDto {
    private String id;
    private String name;
    private int isOccupied;
}
