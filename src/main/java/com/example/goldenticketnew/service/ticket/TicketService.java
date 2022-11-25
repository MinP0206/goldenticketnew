package com.example.goldenticketnew.service.ticket;


import com.example.goldenticketnew.dtos.BillDto;
import com.example.goldenticketnew.dtos.ScheduleDto;
import com.example.goldenticketnew.dtos.SeatDto;
import com.example.goldenticketnew.dtos.TicketDto;
import com.example.goldenticketnew.model.Ticket;
import com.example.goldenticketnew.repository.TicketRepository;
import com.example.goldenticketnew.utils.ModelMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<TicketDto> getTicketsByUserId(Long userId) {
        List<Ticket> ticketList = ticketRepository.findTicketsByUserId(userId);
        List<TicketDto> ticketDtoList = new ArrayList<>();
        TicketDto ticketDto = new TicketDto();
        for(Ticket ticket : ticketList){
            ticketDto.setBill(new BillDto(ticket.getBill()));
            ticketDto.setQrImageURL(ticket.getQrImageURL());
            ticketDto.setSeat(ModelMapperUtils.mapper(ticket.getSeat(), SeatDto.class));
            ticketDto.setId(ticket.getId());
            ticketDto.setSchedule(new ScheduleDto(ticket.getSchedule()));
            ticketDtoList.add(ticketDto);
        }
        return ticketDtoList;
    }
}