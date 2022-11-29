package com.example.goldenticketnew.controller;

import com.example.goldenticketnew.dtos.ArticleDto;
import com.example.goldenticketnew.dtos.MovieDto;
import com.example.goldenticketnew.enums.ArticleType;
import com.example.goldenticketnew.payload.article.request.AddNewArticleRequest;
import com.example.goldenticketnew.payload.article.request.ChangeArticleStatusRequest;
import com.example.goldenticketnew.payload.article.request.GetAllArticleRequest;
import com.example.goldenticketnew.payload.article.request.UpdateArticleRequest;
import com.example.goldenticketnew.payload.response.ApiResponse;
import com.example.goldenticketnew.payload.response.PageResponse;
import com.example.goldenticketnew.payload.response.ResponseBase;
import com.example.goldenticketnew.payload.resquest.GetAllMovieRequest;
import com.example.goldenticketnew.service.article.IArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/article")

@Tag(name = "Article Controller", description = "Thao tác với các bài đăng")
public class ArticleController {

    @Autowired
    private IArticleService articleService;
    @Operation(
        summary = "Thêm mới Review của User ",
        description = "- Thêm mới Review của User"
    )
    @PostMapping("/addNewReview")
    public ResponseEntity<ResponseBase<ArticleDto>> addNewArticleReview(@Valid @RequestBody AddNewArticleRequest request) {
        request.setType(ArticleType.REVIEWS);
        return ResponseEntity.ok(new ResponseBase<>(articleService.addNewArticle(request)));
    }
    @Operation(
        summary = "Thêm mới tin tức, sự kiện khuyến mãi của Staff",
        description = "- Thêm mới tin tức, sự kiện khuyến mãi của Staff"
    )
    @PostMapping("/addNew")
    public ResponseEntity<ResponseBase<ArticleDto>> addNewArticleNew(@Valid @RequestBody AddNewArticleRequest request) {
        request.setType(ArticleType.NEWS);
        return ResponseEntity.ok(new ResponseBase<>(articleService.addNewArticle(request)));
    }
    @Operation(
        summary = "Chỉnh sửa Article ",
        description = "- Chỉnh sửa Article"
    )
    @PutMapping("/update")
    public ResponseEntity<ResponseBase<ArticleDto>> updateArticle(@Valid @RequestBody UpdateArticleRequest request) {
        return ResponseEntity.ok(new ResponseBase<>(articleService.updateArticle(request)));
    }
    @Operation(
        summary = "Chỉnh sửa trạng thái của Article ",
        description = "- Chỉnh sửa trạng thái của Article"
    )
    @PutMapping("/changeStatus")
    public ResponseEntity<ApiResponse> changeStatusArticle(@Valid @RequestBody ChangeArticleStatusRequest request) {
        if(articleService.changeStatusArticle(request))
            return ResponseEntity.ok(new ApiResponse(true, "Change Status Article Successfully"));
        return ResponseEntity.ok(new ApiResponse(false, "!Please try again"));
    }
    @Operation(
        summary = "Get All Article với filter ",
        description = "- Get All Article với filter"
    )
    @GetMapping("/getAll")
    public ResponseEntity<ResponseBase<List<ArticleDto>>> findAllArticle(@ParameterObject GetAllArticleRequest request) {
        return ResponseEntity.ok(new ResponseBase<>(articleService.getAllArticle(request)));
    }

    @Operation(
        summary = "Get All Article với filter và paging ",
        description = "- Get All Article với filter và paging"
    )
    @GetMapping("/getAllPaging")
    public ResponseBase<PageResponse<ArticleDto>> findAllArticlePaging(@ParameterObject Pageable pageable, @ParameterObject GetAllArticleRequest request) {
        request.setPageable(pageable);
        return new ResponseBase<>(articleService.getAllArticlePaging(request));
    }


}
