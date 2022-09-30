package com.example.goldenmovieticketnew.controllers;

import com.example.goldenmovieticketnew.dtos.TicketDto;
import com.example.goldenmovieticketnew.services.Ticket.TicketService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/api/tickets", produces = "application/json")
@Api(value = "Ticket APIs")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<TicketDto> getTicketsByUserId(@RequestParam String userId){
        return ticketService.getTicketsByUserId(userId);
    }
}
