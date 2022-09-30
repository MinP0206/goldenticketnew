package com.example.goldenmovieticketnew.controllers;

import com.example.goldenmovieticketnew.dtos.RoomDto;
import com.example.goldenmovieticketnew.services.Room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<RoomDto> getRooms(){
        return roomService.getAllRoom();
    }
}
