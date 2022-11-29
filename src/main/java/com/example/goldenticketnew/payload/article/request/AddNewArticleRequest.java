package com.example.goldenticketnew.payload.article.request;

import com.example.goldenticketnew.dtos.ContentDto;
import com.example.goldenticketnew.enums.ArticleType;
import com.example.goldenticketnew.model.Article;
import com.example.goldenticketnew.model.Content;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class AddNewArticleRequest {
    private String mainImage;
    @NotNull
    private String title;
    @NotNull
    private String brief;
    @JsonIgnore
    private ArticleType type;
    @NotEmpty
    private List<ContentDto> contents;
}
