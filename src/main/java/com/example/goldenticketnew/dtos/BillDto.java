package com.example.goldenticketnew.dtos;

import com.example.goldenticketnew.model.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BillDto {
    private int id;
    private LocalDateTime createdTime;
    private List<TicketDto> listTickets;
    private User user;
}
