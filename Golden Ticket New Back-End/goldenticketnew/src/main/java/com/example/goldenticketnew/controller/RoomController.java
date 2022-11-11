package com.example.goldenticketnew.controller;


import com.example.goldenticketnew.dtos.RoomDto;
import com.example.goldenticketnew.service.room.IRoomService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/rooms")
@Tag(name = "Room Controller", description = "Thao tác với auth")
public class RoomController {
    @Autowired
    private IRoomService roomService;

    @GetMapping
    public List<RoomDto> getRooms(@RequestParam Integer movieId, @RequestParam Integer branchId,
                                  @RequestParam String startDate, @RequestParam String startTime){
        return roomService.getRooms(movieId, branchId, startDate, startTime);
    }
}
