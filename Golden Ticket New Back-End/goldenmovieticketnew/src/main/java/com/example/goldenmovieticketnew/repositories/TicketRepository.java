package com.example.goldenmovieticketnew.repositories;

import com.example.goldenmovieticketnew.models.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends MongoRepository<Ticket, String> {
    List<Ticket> findTicketsBySchedule_Id(String scheduleId);
    List<Ticket> findTicketsBySchedule_IdAndSeat_Id(String scheduleId,Integer seatId);
    @Query("{}")
    List<Ticket> findTicketsByUserId(@Param("userId") String userId);
}
