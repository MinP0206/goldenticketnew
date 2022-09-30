package com.example.goldenmovieticketnew.services.Schedule;

import com.example.goldenmovieticketnew.dtos.ScheduleDto;

import java.time.LocalDate;
import java.util.List;

public interface IScheduleService {
    List<String> getStartTimes(String movieId, String branchId, LocalDate startDate);

    //tam thoi get all
    List<ScheduleDto> getAll();
    List<ScheduleDto> getSchedules(String movieId, String branchId, String startDate, String startTime,
                                   String roomId);

}
