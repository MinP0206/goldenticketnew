package com.example.goldenmovieticketnew.services.Ticket;

import com.example.goldenmovieticketnew.dtos.TicketDto;

import java.util.List;

public interface ITicketService {

    List<TicketDto> getTicketsByUserId(String userId);
}
