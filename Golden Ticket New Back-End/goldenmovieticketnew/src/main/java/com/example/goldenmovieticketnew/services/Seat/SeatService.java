package com.example.goldenmovieticketnew.services.Seat;

import com.example.goldenmovieticketnew.dtos.SeatDto;
import com.example.goldenmovieticketnew.dtos.TicketDto;
import com.example.goldenmovieticketnew.models.Room;
import com.example.goldenmovieticketnew.models.Seat;
import com.example.goldenmovieticketnew.repositories.ScheduleRepository;
import com.example.goldenmovieticketnew.repositories.SeatRepository;
import com.example.goldenmovieticketnew.repositories.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatService implements ISeatService {
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<SeatDto> getSeatsByScheduleId(String scheduleId) {



        return seatRepository.findAll().stream().map(seat -> modelMapper.map(seat, SeatDto.class))
                .collect(Collectors.toList());
    }

}
