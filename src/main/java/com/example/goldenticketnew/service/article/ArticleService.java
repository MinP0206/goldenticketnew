package com.example.goldenticketnew.service.article;

import com.example.goldenticketnew.dtos.ArticleDto;
import com.example.goldenticketnew.dtos.MovieDto;
import com.example.goldenticketnew.enums.ArticleStatus;
import com.example.goldenticketnew.enums.ResponseCode;
import com.example.goldenticketnew.exception.InternalException;
import com.example.goldenticketnew.model.Article;
import com.example.goldenticketnew.model.Content;
import com.example.goldenticketnew.model.Movie;
import com.example.goldenticketnew.payload.article.request.AddNewArticleRequest;
import com.example.goldenticketnew.payload.article.request.ChangeArticleStatusRequest;
import com.example.goldenticketnew.payload.article.request.GetAllArticleRequest;
import com.example.goldenticketnew.payload.article.request.UpdateArticleRequest;
import com.example.goldenticketnew.payload.response.PageResponse;
import com.example.goldenticketnew.repository.IArticleRepository;
import com.example.goldenticketnew.repository.IContentRepository;
import com.example.goldenticketnew.utils.ModelMapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService implements IArticleService{
    @Autowired
    private IArticleRepository articleRepository;
    @Autowired
    private IContentRepository contentRepository;
    @Override
    public ArticleDto addNewArticle(AddNewArticleRequest request) {
        List<Content> contents = request.getContents();
        Article article = Article.builder()
            .brief(request.getBrief())
            .title(request.getTitle())
            .status(ArticleStatus.CREATE)
            .mainImage(request.getMainImage())
            .build();
        article = articleRepository.save(article);
        for(Content content : request.getContents()){
            content.setArticle(article);
            contentRepository.save(content);
        }
        article.setContents(request.getContents());
        return ModelMapperUtils.mapper(article, ArticleDto.class);
    }

    @Override
    public ArticleDto updateArticle(UpdateArticleRequest request) {
        return null;
    }

    @Override
    public ArticleDto getDetailArticle(Long articleId) {
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new InternalException(ResponseCode.ARTICLE_NOT_FOUND));
        return ModelMapperUtils.mapper(article, ArticleDto.class);
    }

    @Override
    public Boolean changeStatusArticle(ChangeArticleStatusRequest request) {
        return null;
    }

    @Override
    public PageResponse<ArticleDto> getAllArticle(GetAllArticleRequest request) {
        Page<Article> articlePage = articleRepository.findAll(Pageable.unpaged());
        return new PageResponse<>(articlePage.map(ArticleDto::new));
    }


}
