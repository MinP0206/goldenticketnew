package com.example.goldenticketnew.dtos;

import com.example.goldenticketnew.enums.ArticleStatus;
import com.example.goldenticketnew.enums.ArticleType;
import com.example.goldenticketnew.model.Article;
import com.example.goldenticketnew.model.Content;
import com.example.goldenticketnew.utils.ModelMapperUtils;
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
    private List<ContentDto> contents;
    private ArticleStatus status;

    private ArticleType type;

    public ArticleDto(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.brief = article.getBrief();
        this.contents = ModelMapperUtils.mapList(article.getContents(), ContentDto.class);
        this.status = article.getStatus();
    }
}
