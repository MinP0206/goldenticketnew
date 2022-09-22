package com.example.goldenmovieticketnew.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@NoArgsConstructor
public class Ticket {
    @Id
    private String id;
    private String qrImageURL;

    @DBRef
    private Seat seat;
    @DBRef
    private Schedule schedule;
    @DBRef
    private Bill bill;
}
