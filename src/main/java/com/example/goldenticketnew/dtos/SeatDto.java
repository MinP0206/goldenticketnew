package com.example.goldenticketnew.dtos;

import lombok.Data;

@Data
public class SeatDto {
    private int id;
    private String name;
    private int isOccupied;
}
