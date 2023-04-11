package com.example.goldenticketnew.payload.article.request;

import com.example.goldenticketnew.dtos.ContentDto;
import com.example.goldenticketnew.enums.ArticleType;
import com.example.goldenticketnew.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

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
    @NotNull
    private String description;

    private String image1;

    private Long categoryId;

    private String keyword;


}
