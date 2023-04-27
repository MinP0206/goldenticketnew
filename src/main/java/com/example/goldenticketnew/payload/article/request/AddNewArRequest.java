package com.example.goldenticketnew.payload.article.request;

import com.example.goldenticketnew.enums.ArticleStatus;
import com.example.goldenticketnew.enums.ArticleType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddNewArRequest {
    private String mainImage;
    @NotNull
    private String title;
    @NotNull
    private String brief;
    @NotNull
    private String description;
    @JsonIgnore
    private ArticleType type;
    @JsonIgnore
    private ArticleStatus status;


    private Long categoryId;

    private String keyword;

}
