package com.example.goldenmovieticketnew.repositories;

import com.example.goldenmovieticketnew.models.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface RoomRepository extends MongoRepository<Room, String>  {
    @Query("{}")
    List<Room> getRoomByBranchAndMovieAndSchedule(@Param("movieId") String movieId,
                                                  @Param("branchId") String branchId,
                                                  @Param("startDate") LocalDate startDate,
                                                  @Param("startTime") LocalTime startTime);

}
