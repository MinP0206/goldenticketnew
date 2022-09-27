package com.example.goldenmovieticketnew.dtos;

import lombok.Data;

import java.util.List;

@Data
public class BookingRequestDto {
    private String userId;
    private String scheduleId;
    private List<String> listSeatIds;
}
