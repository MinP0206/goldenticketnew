package com.example.goldenmovieticketnew.dtos;

import lombok.Data;

@Data
public class TicketDto {
    private String id;
    private String qrImageURL;
    private ScheduleDto schedule;
    private SeatDto seat;
    private BillDto bill;
}
