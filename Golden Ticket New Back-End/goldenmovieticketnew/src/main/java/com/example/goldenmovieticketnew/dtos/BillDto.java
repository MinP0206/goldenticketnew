package com.example.goldenmovieticketnew.dtos;


import com.example.goldenmovieticketnew.models.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BillDto {
    private String id;
    private LocalDateTime createdTime;
    private List<TicketDto> listTickets;
    private User user;
}
