package com.example.goldenticketnew.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ScheduleDto {
    private int id;
    private LocalDate startDate;
    private LocalTime startTime;
    private BranchDto branch;
    private RoomDto room;
    private MovieDto movie;
    private Double price;
}
