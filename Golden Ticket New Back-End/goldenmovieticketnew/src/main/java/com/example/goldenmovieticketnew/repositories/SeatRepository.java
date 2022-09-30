package com.example.goldenmovieticketnew.repositories;


import com.example.goldenmovieticketnew.models.Seat;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SeatRepository extends MongoRepository<Seat, String> {
    List<Seat> getSeatByRoom_Id(String roomId);
}
