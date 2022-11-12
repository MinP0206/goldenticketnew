package com.example.goldenticketnew.service.room;


import com.example.goldenticketnew.dtos.RoomDto;

import java.util.List;

public interface IRoomService {
    List<RoomDto> getRooms(Integer movieId, Integer branchId, String startDate, String startTime);
}
