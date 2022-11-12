package com.example.goldenticketnew.dtos;

import lombok.Data;

import java.util.List;

@Data
public class BookingRequestDto {
    private Long userId;
    private Integer scheduleId;
    private List<Integer> listSeatIds;
}
