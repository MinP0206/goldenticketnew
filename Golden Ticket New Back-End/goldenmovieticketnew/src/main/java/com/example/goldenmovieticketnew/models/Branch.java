package com.example.goldenmovieticketnew.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "branchs")
@NoArgsConstructor
@Getter
@Setter
public class Branch {

    @Id
    private String id;

    private String imgURL;
    private String name;
    private String address;
    private String phoneNo;
}
