package com.example.goldenticketnew.dtos;

import com.example.goldenticketnew.model.Schedule;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.TimeZone;

@Data
public class ScheduleDto {
    private int id;
    private LocalDate startDate;
    private LocalTime startTime;
    private BranchDto branch;
    private RoomDto room;
    private MovieDto movie;
    private Double price;
    private LocalDateTime dateTime;

    private boolean isWaiting = true;

    public ScheduleDto(Schedule schedule) {
        this.id = schedule.getId();
        this.startDate = schedule.getStartDate();

        TimeZone timeZone = TimeZone.getDefault();
        System.out.println("Thoi gian lich chieu timezone:"+ timeZone.getDisplayName()  + "zoneId:"+timeZone.toZoneId()+ " la: " + schedule.getStartTime());
        this.startTime = schedule.getStartTime();
        this.branch = new BranchDto(schedule.getBranch());
        this.room = new RoomDto(schedule.getRoom());
        this.movie = new MovieDto(schedule.getMovie());
        this.price = schedule.getPrice();
        LocalDateTime localDateTime = LocalDateTime.now().minusHours(1);
        System.out.println("Gio hien tai -1 la " + localDateTime);
        System.out.println("gio chieu cua phim la" + schedule.getDateTime());
        if(schedule.getDateTime()!=null){
            System.out.println("gio chieu cua phim la" + schedule.getDateTime());
            if(schedule.getDateTime().isAfter(localDateTime)){
                this.isWaiting = false;
            }
        }
        if(schedule.getDateTime()!=null){
            this.dateTime = schedule.getDateTime();
        }
    }
}
