package com.example.goldenticketnew.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
@Table(name = "content")
@NoArgsConstructor
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;
    @Lob
    private String description;

    private String image;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(nullable = false,name = "article_id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Article article;
}
