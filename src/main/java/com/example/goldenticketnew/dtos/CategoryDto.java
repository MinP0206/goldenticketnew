package com.example.goldenticketnew.dtos;

import com.example.goldenticketnew.model.Article;
import com.example.goldenticketnew.model.Category;
import com.example.goldenticketnew.payload.article.request.GetAllArticleRequest;
import com.example.goldenticketnew.repository.IArticleRepository;
import com.example.goldenticketnew.service.article.ArticleService;
import com.example.goldenticketnew.utils.BeanUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long id;

    private String name;

    private Integer amountArticle = 0;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.name = category.getName();

        IArticleRepository articleRepository = BeanUtils.getBean(IArticleRepository.class);
        GetAllArticleRequest request = new GetAllArticleRequest();
        List<String> cateList = new ArrayList<>();
        cateList.add(category.getName());
        List<Article> articles = articleRepository.findAll(request.getSpecification());
        if(!articles.isEmpty()) this.amountArticle = articles.size();
    }
}
