package com.example.goldenmovieticketnew.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "rooms")
@NoArgsConstructor
public class Room {
    @Id
    private String id;
    private String name;



    private int capacity;
    private double totalArea;

    private String imgURL;

    @DBRef
    private Branch branch;
}