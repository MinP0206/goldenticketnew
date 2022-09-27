package com.example.goldenmovieticketnew.controllers;

import com.example.goldenmovieticketnew.dtos.ScheduleDto;
import com.example.goldenmovieticketnew.services.Schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/schedule", produces = "application/json")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/start-times")
    public List<String> getStartTimes(@RequestParam String movieId, @RequestParam String branchId,
                                      @RequestParam String startDate) {
        return scheduleService.getStartTimes(movieId,branchId, LocalDate.parse(startDate));
    }

    @GetMapping
    public List<ScheduleDto> getSchedules(@RequestParam String movieId, @RequestParam String branchId,
                                          @RequestParam String startDate, @RequestParam String startTime,
                                          @RequestParam String roomId){
        return scheduleService.getSchedules(movieId,branchId,startDate,startTime,roomId);
    }

    @GetMapping("/all")
    public List<ScheduleDto> getAllSchedule(){
        return scheduleService.getAll();
    }
}
