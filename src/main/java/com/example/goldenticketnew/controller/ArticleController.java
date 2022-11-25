package com.example.goldenticketnew.controller;

import com.example.goldenticketnew.dtos.ArticleDto;
import com.example.goldenticketnew.dtos.MovieDto;
import com.example.goldenticketnew.payload.article.request.AddNewArticleRequest;
import com.example.goldenticketnew.payload.article.request.GetAllArticleRequest;
import com.example.goldenticketnew.payload.response.PageResponse;
import com.example.goldenticketnew.payload.response.ResponseBase;
import com.example.goldenticketnew.payload.resquest.GetAllMovieRequest;
import com.example.goldenticketnew.service.article.IArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/article")

@Tag(name = "Article Controller", description = "Thao tác với các bài đăng")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @PostMapping("/addNew")
    public ResponseEntity<ResponseBase<ArticleDto>> addNewArticle(@Valid @RequestBody AddNewArticleRequest request){
        return ResponseEntity.ok(new ResponseBase<>(articleService.addNewArticle(request)));
    }
    @Operation(
        summary = "Get All Article với filter ",
        description = "- Get All Article với filter"
    )
    @GetMapping("/getAll")
    public ResponseBase<PageResponse<ArticleDto>> findAllArticle(@ParameterObject Pageable pageable, @ParameterObject GetAllArticleRequest request){
        request.setPageable(pageable);
        return new ResponseBase<>(articleService.getAllArticle(request));
    }


}
