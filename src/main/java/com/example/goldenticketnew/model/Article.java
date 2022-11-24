package com.example.goldenticketnew.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "article")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "brief")
    private String brief;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "article")
    List<Content> contents;


}
