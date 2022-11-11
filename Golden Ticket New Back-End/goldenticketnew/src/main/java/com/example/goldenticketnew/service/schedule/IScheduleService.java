package com.example.goldenticketnew.service.schedule;


import com.example.goldenticketnew.dtos.ScheduleDto;

import java.time.LocalDate;
import java.util.List;

public interface IScheduleService {
    List<String> getStartTimes(Integer movieId, Integer branchId, LocalDate startDate);
    List<ScheduleDto> getSchedules(Integer movieId, Integer branchId, String startDate, String startTime,
                                   Integer roomId);
}
