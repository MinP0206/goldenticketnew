package com.example.goldenticketnew.dtos;

import com.example.goldenticketnew.enums.SeatType;
import lombok.Data;

@Data
public class SeatDto {
    private int id;
    private String name;
    private SeatType type;
    private int isOccupied;
}
