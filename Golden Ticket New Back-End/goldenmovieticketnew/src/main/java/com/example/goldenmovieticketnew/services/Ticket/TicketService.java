package com.example.goldenmovieticketnew.services.Ticket;

import com.example.goldenmovieticketnew.dtos.TicketDto;
import com.example.goldenmovieticketnew.repositories.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class TicketService implements ITicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<TicketDto> getTicketsByUserId(String userId) {
        return ticketRepository.findTicketsByUserId(userId)
                .stream().map(ticket -> modelMapper.map(ticket,TicketDto.class))
                .collect(Collectors.toList());
    }
}
