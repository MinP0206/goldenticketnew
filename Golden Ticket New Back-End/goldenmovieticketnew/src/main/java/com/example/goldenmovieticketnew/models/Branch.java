package com.example.goldenmovieticketnew.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "branchs")
@NoArgsConstructor
public class Branch {
    @Id
    private String id;

    private String imgURL;
    private String name;
    private String address;
    private String phoneNo;
}
