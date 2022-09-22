package com.example.goldenmovieticketnew.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "rooms")
@NoArgsConstructor
public class Seat {
    @Id
    private String id;
    private String name;

    @DBRef
    private Room room;
}
