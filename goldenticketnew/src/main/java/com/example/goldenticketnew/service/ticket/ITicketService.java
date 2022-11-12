package com.example.goldenticketnew.service.ticket;

import com.example.goldenticketnew.dtos.TicketDto;

import java.util.List;

public interface ITicketService {
    List<TicketDto> getTicketsByUserId(Integer userId);
}
