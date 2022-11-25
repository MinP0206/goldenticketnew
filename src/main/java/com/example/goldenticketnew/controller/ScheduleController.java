package com.example.goldenticketnew.controller;

import com.example.goldenticketnew.dtos.ScheduleDto;
import com.example.goldenticketnew.payload.response.PageResponse;
import com.example.goldenticketnew.payload.response.ResponseBase;
import com.example.goldenticketnew.payload.resquest.GetAllScheduleRequest;
import com.example.goldenticketnew.service.schedule.IScheduleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/schedule", produces = "application/json")
@Tag(name = "Schedule Controller", description = "Thao tác với Schedule")
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
    @Operation(
        summary = "Get All Schedule với filter ",
        description = "- Get All Schedule với filter"
    )
    @GetMapping("/getAll")
    public ResponseEntity<ResponseBase<PageResponse<ScheduleDto>>> getSchedules(@ParameterObject Pageable pageable, @ParameterObject GetAllScheduleRequest request ){
        request.setPageable(pageable);
        return new ResponseEntity<>(new ResponseBase<>(scheduleService.getAllSchedule(request)), HttpStatus.OK);
    }

}
