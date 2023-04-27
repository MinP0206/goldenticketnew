package com.example.goldenticketnew.service.article;

import com.example.goldenticketnew.dtos.ArticleDto;
import com.example.goldenticketnew.enums.ArticleStatus;
import com.example.goldenticketnew.model.Article;
import com.example.goldenticketnew.payload.article.request.*;
import com.example.goldenticketnew.payload.response.PageResponse;
import com.example.goldenticketnew.security.UserPrincipal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IArticleService {
    ArticleDto addNewArticle(AddNewArticleRequest request);
    ArticleDto addNewArticleReview(AddNewReviewRequest request);
    ArticleDto addNewArticleNews(AddNewArRequest request);

    ArticleDto publicDraft(Long id);
    ArticleDto updateArticle(UpdateArticleRequest request);

    ArticleDto getDetailArticle(Long articleId);

    ArticleDto changeStatusArticle(ChangeArticleStatusRequest request);

    PageResponse<ArticleDto> getAllArticlePaging(GetAllArticleRequest request);

    List<ArticleDto> getAllArticle(GetAllArticleRequest request);

    void deleteArticle(Long articleId);
    List<ArticleDto> getAllByUser(UserPrincipal currentUser, ArticleStatus status);

    Article getArticle(Long id);


}
