package com.example.goldenmovieticketnew.services.Schedule;

import com.example.goldenmovieticketnew.dtos.ScheduleDto;
import com.example.goldenmovieticketnew.repositories.ScheduleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService implements IScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<String> getStartTimes(String movieId, String branchId, LocalDate startDate) {
        return scheduleRepository.getStartTimeByMovie_IdAndBranch_IdAndStartDate(movieId,branchId,startDate)
                .stream().map(localTime -> localTime.format(DateTimeFormatter.ofPattern("HH:mm")))
                .collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDto> getAll() {
        return scheduleRepository.findAll()
                .stream().map(schedule -> modelMapper.map(schedule,ScheduleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDto> getSchedules(String movieId, String branchId, String startDate, String startTime, String roomId) {
        return scheduleRepository.getSchedulesByMovie_IdAndBranch_IdAndStartDateAndStartTimeAndRoom_Id(movieId,branchId
                        ,LocalDate.parse(startDate), LocalTime.parse(startTime), roomId)
                .stream().map(schedule -> modelMapper.map(schedule,ScheduleDto.class))
                .collect(Collectors.toList());
    }
}

