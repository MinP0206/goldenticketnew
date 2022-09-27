package com.example.goldenmovieticketnew.repositories;

import com.example.goldenmovieticketnew.models.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ScheduleRepository extends MongoRepository<Schedule, String> {
    @Query("{}")
    List<LocalTime> getStartTimeByMovie_IdAndBranch_IdAndStartDate(@Param("movieId") String movieId
            , @Param("branchId") String branchId
            , @Param("startDate") LocalDate startDate);

    List<Schedule> getSchedulesByMovie_IdAndBranch_IdAndStartDateAndStartTimeAndRoom_Id(String movieId,String branchId
            , LocalDate startDate,LocalTime startTime,String roomId);
}
