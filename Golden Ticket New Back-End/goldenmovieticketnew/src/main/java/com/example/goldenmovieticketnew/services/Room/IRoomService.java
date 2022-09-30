package com.example.goldenmovieticketnew.services.Room;

import com.example.goldenmovieticketnew.dtos.RoomDto;

import java.util.List;

public interface IRoomService {
    List<RoomDto> getRooms(String movieId, String branchId, String startDate, String startTime);
    List<RoomDto> getAllRoom();
}
