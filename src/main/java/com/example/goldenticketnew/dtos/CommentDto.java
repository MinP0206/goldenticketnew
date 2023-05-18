package com.example.goldenticketnew.dtos;

import com.example.goldenticketnew.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long id;
    private String description;
    private String name;
    private String image;

    private String username;
    private Long articleId;
    private Long userId;
    private String createdAt;

    private String modifiedBy;

    public CommentDto(Comment comment){
        this.id = comment.getId();
        this.description = comment.getDescription();
        this.username = comment.getUser().getUsername();
        this.name = comment.getUser().getName();
        if(comment.getUser().getImage()!=null) this.image = comment.getUser().getImage();
        this.articleId = comment.getArticle().getId();
        this.userId = comment.getUser().getId();
        this.createdAt = comment.getCreatedAt().toString();
        this.modifiedBy = comment.getUpdatedAt().toString();
    }
}
