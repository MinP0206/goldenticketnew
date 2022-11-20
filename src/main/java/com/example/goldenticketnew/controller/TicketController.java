package com.example.goldenticketnew.controller;


import com.example.goldenticketnew.dtos.TicketDto;
import com.example.goldenticketnew.service.ticket.ITicketService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tickets")
@Tag(name = "Ticket Controller", description = "Thao tác với Ticket")
public class TicketController {
    @Autowired
    private ITicketService ticketService;

    @GetMapping
    public List<TicketDto> getTicketsByUserId(@RequestParam Long userId){
        return ticketService.getTicketsByUserId(userId);
    }
}
