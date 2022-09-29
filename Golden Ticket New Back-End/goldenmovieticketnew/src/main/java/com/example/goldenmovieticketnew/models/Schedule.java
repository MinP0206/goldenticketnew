package com.example.goldenmovieticketnew.models;




import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@NoArgsConstructor
@Document(collection = "schedules")
public class Schedule {

    @Id
    private String id;





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

