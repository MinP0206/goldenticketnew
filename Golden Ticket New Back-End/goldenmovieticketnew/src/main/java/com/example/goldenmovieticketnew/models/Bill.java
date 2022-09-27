package com.example.goldenmovieticketnew.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "bills")
@NoArgsConstructor
public class Bill {
    @Id
    private int id;
    @CreatedDate
    private LocalDateTime createdTime;
    @DBRef
    private User user;
}
