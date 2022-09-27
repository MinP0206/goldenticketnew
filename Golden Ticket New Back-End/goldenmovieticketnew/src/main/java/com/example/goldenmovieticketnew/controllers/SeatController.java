package com.example.goldenmovieticketnew.controllers;

import com.example.goldenmovieticketnew.dtos.SeatDto;
import com.example.goldenmovieticketnew.services.Seat.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/seats")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @GetMapping
    public List<SeatDto> getSeatsByScheduleId(@RequestParam String scheduleId){
        return seatService.getSeatsByScheduleId(scheduleId);
    }
}