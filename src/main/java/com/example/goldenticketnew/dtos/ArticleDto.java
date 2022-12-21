package com.example.goldenticketnew.dtos;

import com.example.goldenticketnew.enums.ArticleStatus;
import com.example.goldenticketnew.enums.ArticleType;
import com.example.goldenticketnew.model.Article;
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
    private ArticleStatus status;
    private String mainImage;
    private String image1;
    private String description;

    private ArticleType type;

    public ArticleDto(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.brief = article.getBrief();
        this.mainImage = article.getMainImage();
        if(article.getDescription()!=null) this.description = article.getDescription();
        if(article.getImage1()!=null)this.image1 = article.getImage1();
        this.status = article.getStatus();
    }
}
