package com.example.goldenticketnew.dtos;

import com.example.goldenticketnew.enums.ArticleStatus;
import com.example.goldenticketnew.model.Article;
import com.example.goldenticketnew.model.Content;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    private Long id;
    private String title;
    private String brief;
    private List<Content> contents;
    private ArticleStatus status;

    public ArticleDto(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.brief = article.getBrief();
        this.contents = article.getContents();
        this.status = article.getStatus();
    }
}
