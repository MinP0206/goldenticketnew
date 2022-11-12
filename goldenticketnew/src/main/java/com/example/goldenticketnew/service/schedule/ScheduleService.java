package com.example.goldenticketnew.service.schedule;


import com.example.goldenticketnew.dtos.ScheduleDto;
import com.example.goldenticketnew.repository.IScheduleRepository;
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
    private IScheduleRepository IScheduleRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<String> getStartTimes(Integer movieId, Integer branchId, LocalDate startDate) {
        return IScheduleRepository.getStartTimeByMovie_IdAndBranch_IdAndStartDate(movieId,branchId,startDate)
                .stream().map(localTime -> localTime.format(DateTimeFormatter.ofPattern("HH:mm")))
                .collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDto> getSchedules(Integer movieId, Integer branchId, String startDate, String startTime, Integer roomId) {
        return IScheduleRepository.getSchedulesByMovie_IdAndBranch_IdAndStartDateAndStartTimeAndRoom_Id(movieId,branchId
                        ,LocalDate.parse(startDate),LocalTime.parse(startTime), roomId)
                .stream().map(schedule -> modelMapper.map(schedule, ScheduleDto.class))
                .collect(Collectors.toList());
    }
}
