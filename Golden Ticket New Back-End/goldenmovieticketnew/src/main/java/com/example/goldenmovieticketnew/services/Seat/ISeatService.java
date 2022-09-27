package com.example.goldenmovieticketnew.services.Seat;

import com.example.goldenmovieticketnew.dtos.SeatDto;

import java.util.List;

public interface ISeatService {
    List<SeatDto> getSeatsByScheduleId(String scheduleId);
}
