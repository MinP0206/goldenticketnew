package com.example.goldenticketnew.payload.article.request;

import com.example.goldenticketnew.model.Content;
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
    @NotEmpty
    private List<Content> contents;



}
