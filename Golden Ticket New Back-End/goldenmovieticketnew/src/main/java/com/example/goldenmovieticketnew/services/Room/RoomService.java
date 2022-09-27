package com.example.goldenmovieticketnew.services.Room;

import com.example.goldenmovieticketnew.dtos.RoomDto;
import com.example.goldenmovieticketnew.dtos.ScheduleDto;
import com.example.goldenmovieticketnew.repositories.RoomRepository;
import com.example.goldenmovieticketnew.repositories.ScheduleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService implements IRoomService{
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<RoomDto> getRooms(String movieId, String branchId, String startDate, String startTime) {
        return roomRepository.findAll()
                .stream().map(room -> modelMapper.map(room, RoomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<RoomDto> getAllRoom() {
        return roomRepository.findAll()
                .stream().map(room -> modelMapper.map(room, RoomDto.class))
                .collect(Collectors.toList());
    }
}
