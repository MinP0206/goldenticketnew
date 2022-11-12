package com.example.goldenticketnew.dtos;

import lombok.Data;

@Data
public class TicketDto {
    private int id;
    private String qrImageURL;
    private ScheduleDto schedule;
    private SeatDto seat;
    private BillDto bill;
}
