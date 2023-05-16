package com.example.goldenticketnew.dtos;

import com.example.goldenticketnew.model.Category;
import com.example.goldenticketnew.payload.article.request.GetAllArticleRequest;
import com.example.goldenticketnew.service.article.ArticleService;
import com.example.goldenticketnew.utils.BeanUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long id;

    private String name;

    private Integer amountArticle;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        ArticleService articleService = BeanUtils.getBean(ArticleService.class);
        GetAllArticleRequest request = new GetAllArticleRequest();
        request.setCategory(category.getName());
        this.amountArticle = articleService.getAllArticle(request).size();
    }
}
