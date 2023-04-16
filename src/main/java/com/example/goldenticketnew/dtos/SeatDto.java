package com.example.goldenticketnew.dtos;

import com.example.goldenticketnew.enums.SeatType;
import com.example.goldenticketnew.model.Seat;
import lombok.Data;

@Data
public class SeatDto {
    private int id;
    private String name;
    private SeatType type;
    private int isOccupied;

    public SeatDto(Seat seat) {
        this.id = seat.getId();
        this.name = seat.getName();
        if(seat.getSeatType() != null) this.type = seat.getSeatType();
    }
}
