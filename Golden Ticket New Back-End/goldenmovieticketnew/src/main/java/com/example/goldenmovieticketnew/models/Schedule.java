package com.example.goldenmovieticketnew.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor

public class Schedule {
    @Id
    private int id;
    private LocalDate startDate;
    private LocalTime startTime;
    private double price;
    @DBRef
    private Movie movie;

    @DBRef
    private Branch branch;

    @DBRef
    private Room room;
}
