package com.example.goldenticketnew.model;

import com.example.goldenticketnew.model.audit.UserDateAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comment")
@FieldNameConstants
public class Comment extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Boolean isActive;

    @OneToOne( fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "id")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false,name = "article_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Article article;
}
