package com.example.goldenticketnew.controller;


import com.example.goldenticketnew.dtos.ScheduleDto;
import com.example.goldenticketnew.service.schedule.IScheduleService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/schedule", produces = "application/json")
@Tag(name = "Schedule Controller", description = "Thao tác với auth")
public class ScheduleController {
    @Autowired
    private IScheduleService scheduleService;

    @GetMapping("/start-times")
    public List<String> getStartTimes(@RequestParam Integer movieId, @RequestParam Integer branchId,
                                         @RequestParam String startDate) {
        return scheduleService.getStartTimes(movieId,branchId,LocalDate.parse(startDate));
    }

    @GetMapping
    public List<ScheduleDto> getSchedules(@RequestParam Integer movieId, @RequestParam Integer branchId,
                                          @RequestParam String startDate, @RequestParam String startTime,
                                          @RequestParam Integer roomId){
        return scheduleService.getSchedules(movieId,branchId,startDate,startTime,roomId);
    }
}
