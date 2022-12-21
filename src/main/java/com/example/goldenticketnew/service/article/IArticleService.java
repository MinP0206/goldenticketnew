package com.example.goldenticketnew.service.article;

import com.example.goldenticketnew.dtos.ArticleDto;
import com.example.goldenticketnew.dtos.ReviewDto;
import com.example.goldenticketnew.payload.article.request.*;
import com.example.goldenticketnew.payload.response.PageResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IArticleService {
    ArticleDto addNewArticle(AddNewArticleRequest request);
    ReviewDto addNewArticleReview(AddNewReviewRequest request);
    ArticleDto updateArticle(UpdateArticleRequest request);

    ArticleDto getDetailArticle(Long articleId);

    ArticleDto changeStatusArticle(ChangeArticleStatusRequest request);

    PageResponse<ArticleDto> getAllArticlePaging(GetAllArticleRequest request);

    List<ArticleDto> getAllArticle(GetAllArticleRequest request);

    void deleteArticle(Long articleId);
}
