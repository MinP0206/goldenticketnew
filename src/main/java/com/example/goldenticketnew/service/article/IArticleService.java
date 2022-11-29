package com.example.goldenticketnew.service.article;

import com.example.goldenticketnew.dtos.ArticleDto;
import com.example.goldenticketnew.payload.article.request.AddNewArticleRequest;
import com.example.goldenticketnew.payload.article.request.ChangeArticleStatusRequest;
import com.example.goldenticketnew.payload.article.request.GetAllArticleRequest;
import com.example.goldenticketnew.payload.article.request.UpdateArticleRequest;
import com.example.goldenticketnew.payload.response.PageResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IArticleService {
    ArticleDto addNewArticle(AddNewArticleRequest request);

    ArticleDto updateArticle(UpdateArticleRequest request);

    ArticleDto getDetailArticle(Long articleId);

    Boolean changeStatusArticle(ChangeArticleStatusRequest request);

    PageResponse<ArticleDto> getAllArticlePaging(GetAllArticleRequest request);

    List<ArticleDto> getAllArticle(GetAllArticleRequest request);
}
