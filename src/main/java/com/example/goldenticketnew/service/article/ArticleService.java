package com.example.goldenticketnew.service.article;

import com.example.goldenticketnew.dtos.ArticleDto;

import com.example.goldenticketnew.dtos.ContentDto;
import com.example.goldenticketnew.enums.ArticleStatus;
import com.example.goldenticketnew.enums.ResponseCode;
import com.example.goldenticketnew.exception.InternalException;
import com.example.goldenticketnew.model.Article;
import com.example.goldenticketnew.model.Content;
import com.example.goldenticketnew.payload.article.request.*;
import com.example.goldenticketnew.payload.response.PageResponse;
import com.example.goldenticketnew.repository.IArticleRepository;
import com.example.goldenticketnew.repository.IContentRepository;
import com.example.goldenticketnew.utils.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ArticleService implements IArticleService{
    @Autowired
    private IArticleRepository articleRepository;
    @Autowired
    private IContentRepository contentRepository;
    @Override
    public ArticleDto addNewArticle(AddNewArticleRequest request) {
        Article article = Article.builder()
            .brief(request.getBrief())
            .title(request.getTitle())
            .status(ArticleStatus.CREATE)
            .mainImage(request.getMainImage())
            .type(request.getType())
            .build();
        article = articleRepository.save(article);
        List<Content> contents = ModelMapperUtils.mapList(request.getContents(), Content.class);
        for(Content content : contents){
            content.setArticle(article);
            contentRepository.save(content);
        }
        article.setContents(contents);
        return ModelMapperUtils.mapper(article, ArticleDto.class);
    }

    @Transactional
    @Override
    public ArticleDto updateArticle(UpdateArticleRequest request) {
        Article article = articleRepository.findById(request.getId()).orElseThrow(() -> new InternalException(ResponseCode.ARTICLE_NOT_FOUND));
        if(!request.getBrief().isBlank()) article.setBrief(request.getBrief());
        if(!request.getTitle().isBlank()) article.setTitle(request.getTitle());
        if(request.getContents() != null){
            List<Content> contents = ModelMapperUtils.mapList(request.getContents(), Content.class);
            contentRepository.deleteAllByArticleId(request.getId());
            for(Content content : contents){
                content.setArticle(article);
                contentRepository.save(content);
            }
            article.setContents(contents);
        }
        return ModelMapperUtils.mapper(article, ArticleDto.class);
    }

    @Override
    public ArticleDto getDetailArticle(Long articleId) {
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new InternalException(ResponseCode.ARTICLE_NOT_FOUND));
        return ModelMapperUtils.mapper(article, ArticleDto.class);
    }

    @Override
    public Boolean changeStatusArticle(ChangeArticleStatusRequest request) {
        Article article = articleRepository.findById(request.getArticleId()).orElseThrow(()-> new InternalException(ResponseCode.ARTICLE_NOT_FOUND));
        article.setStatus(request.getStatus());
        return true;
    }

    @Override
    public PageResponse<ArticleDto> getAllArticlePaging(GetAllArticleRequest request) {
        Page<Article> articlePage = articleRepository.findAll(request.getSpecification(),request.getPageable());
        return new PageResponse<>(articlePage.map(ArticleDto::new));
    }
    @Override
    public List<ArticleDto> getAllArticle(GetAllArticleRequest request) {
        List<Article> articles = articleRepository.findAll(request.getSpecification());
        return ModelMapperUtils.mapList(articles, ArticleDto.class);
    }

}
