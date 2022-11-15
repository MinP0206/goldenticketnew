package com.example.goldenticketnew.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Table(name = "room")
@Entity
@NoArgsConstructor
@FieldNameConstants
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int capacity;
    private double totalArea;

    @Column(length = 1000)
    private String imgURL;

    @ManyToOne
    @JoinColumn(nullable = false,name = "branch_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Branch branch;
}
