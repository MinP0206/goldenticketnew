package com.example.goldenticketnew.model;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;


@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
@FieldNameConstants
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",unique = true)
    private String name;
    
}