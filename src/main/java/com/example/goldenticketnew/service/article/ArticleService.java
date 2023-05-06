package com.example.goldenticketnew.service.article;

import com.example.goldenticketnew.dtos.ArticleDto;
import com.example.goldenticketnew.enums.ArticleStatus;
import com.example.goldenticketnew.enums.ResponseCode;
import com.example.goldenticketnew.exception.InternalException;
import com.example.goldenticketnew.model.Article;
import com.example.goldenticketnew.model.Category;
import com.example.goldenticketnew.payload.article.request.*;
import com.example.goldenticketnew.payload.response.PageResponse;
import com.example.goldenticketnew.repository.IArticleRepository;
import com.example.goldenticketnew.repository.ICategoryRepository;
import com.example.goldenticketnew.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ArticleService implements IArticleService{

    private final IArticleRepository articleRepository;

    private final ICategoryRepository categoryRepository;



    @Override
    public ArticleDto addNewArticle(AddNewArticleRequest request) {
        Article article = Article.builder()
            .brief(request.getBrief())
            .title(request.getTitle())
            .status(ArticleStatus.CREATE)
            .mainImage(request.getMainImage())
            .type(request.getType())
            .keyword(request.getKeyword())
            .build();
        article = articleRepository.save(article);
        return new ArticleDto(article);
    }

    @Override
    public ArticleDto addNewArticleReview(AddNewReviewRequest request) {
        Article article = Article.builder()
            .brief(request.getBrief())
            .title(request.getTitle())
            .status(ArticleStatus.CREATE)
            .mainImage(request.getMainImage())
            .type(request.getType())
            .description(request.getDescription())
            .keyword(request.getKeyword())
            .build();
        article = articleRepository.save(article);
        return new ArticleDto(article);
    }

    @Override
    public ArticleDto addNewArticleNews(AddNewArRequest request) {
        Category category = null;
        if(request.getCategoryId() !=null){
            category = categoryRepository.getById(request.getCategoryId());
        }
        Article article = Article.builder()
            .brief(request.getBrief())
            .title(request.getTitle())
            .status(request.getStatus()==null ? ArticleStatus.CREATE : request.getStatus())
            .mainImage(request.getMainImage())
            .type(request.getType())
            .category(category)
            .keyword(request.getKeyword())
            .build();
        article = articleRepository.save(article);
        return new ArticleDto(article);
    }

    @Override
    public ArticleDto publicDraft(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(()-> new InternalException(ResponseCode.ARTICLE_NOT_FOUND));
        article.setStatus(ArticleStatus.CREATE);
        article = articleRepository.save(article);
        return new ArticleDto(article);
    }

    @Transactional
    @Override
    public ArticleDto updateArticle(UpdateArticleRequest request) {
        Article article = articleRepository.findById(request.getId()).orElseThrow(() -> new InternalException(ResponseCode.ARTICLE_NOT_FOUND));
        if(!request.getBrief().isBlank()) article.setBrief(request.getBrief());
        if(!request.getTitle().isBlank()) article.setTitle(request.getTitle());
        if(!request.getDescription().isBlank()) article.setDescription(request.getDescription());
        if(!request.getMainImage().isBlank()) article.setMainImage(request.getMainImage());
        article = articleRepository.saveAndFlush(article);
        return new ArticleDto(article);
    }

    @Override
    public ArticleDto getDetailArticle(Long articleId) {
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new InternalException(ResponseCode.ARTICLE_NOT_FOUND));
        return new ArticleDto(article);
    }

    @Override
    public ArticleDto getArticleBySLug(String slug) {
        Long value = Long.parseLong(slug.replaceAll("[^0-9]", ""));
        Article article = articleRepository.findById(value).orElseThrow(() -> new InternalException(ResponseCode.ARTICLE_NOT_FOUND));
        return new ArticleDto(article);
    }

    @Override
    public ArticleDto changeStatusArticle(ChangeArticleStatusRequest request) {
        Article article = articleRepository.findById(request.getArticleId()).orElseThrow(()-> new InternalException(ResponseCode.ARTICLE_NOT_FOUND));
        article.setStatus(request.getStatus());
        article = articleRepository.save(article);
        return new ArticleDto(article);
    }

    @Override
    public PageResponse<ArticleDto> getAllArticlePaging(GetAllArticleRequest request) {
        Page<Article> articlePage = articleRepository.findAll(request.getSpecification(),request.getPageable());
        return new PageResponse<>(articlePage.map(ArticleDto::new));
    }
    @Override
    public List<ArticleDto> getAllArticle(GetAllArticleRequest request) {
        List<Article> articles = new ArrayList<>();
        if(request.getListCategory()!=null) {
            for (String cate : request.getListCategory()) {
                request.setCategory(cate);
                articles.addAll(articleRepository.findAll(request.getSpecification()));
            }
        } else articles = articleRepository.findAll(request.getSpecification());
        return articles.stream().map(ArticleDto::new).collect(Collectors.toList());


    }

    @Override
    public void deleteArticle(Long articleId) {
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new InternalException(ResponseCode.ARTICLE_NOT_FOUND));
        article.setStatus(ArticleStatus.DELETE);
        articleRepository.save(article);
    }

    @Override
    public List<ArticleDto> getAllByUser(UserPrincipal currentUser, ArticleStatus status) {
            GetAllArticleRequest request = new GetAllArticleRequest();
            request.setUsername(currentUser.getUsername());
            request.setStatus(status);
            List<Article> articles = articleRepository.findAll(request.getSpecification());
            return articles.stream().map(ArticleDto::new).collect(Collectors.toList());


    }

    @Override
    public Article getArticle(Long id) {
        return  articleRepository.findById(id).orElseThrow(() -> new InternalException(ResponseCode.ARTICLE_NOT_FOUND));
    }

}
