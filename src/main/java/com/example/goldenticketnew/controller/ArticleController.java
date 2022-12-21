package com.example.goldenticketnew.controller;

import com.example.goldenticketnew.dtos.ArticleDto;
import com.example.goldenticketnew.dtos.MovieDto;
import com.example.goldenticketnew.dtos.ReviewDto;
import com.example.goldenticketnew.enums.ArticleType;
import com.example.goldenticketnew.payload.article.request.*;
import com.example.goldenticketnew.payload.response.ApiResponse;
import com.example.goldenticketnew.payload.response.PageResponse;
import com.example.goldenticketnew.payload.response.ResponseBase;
import com.example.goldenticketnew.payload.resquest.GetAllMovieRequest;
import com.example.goldenticketnew.service.article.IArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
    public ResponseEntity<ResponseBase<ReviewDto>> addNewArticleReview(@Valid @RequestBody AddNewReviewRequest request) {
        request.setType(ArticleType.REVIEWS);
        return ResponseEntity.ok(new ResponseBase<>(articleService.addNewArticleReview(request)));
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
    public ResponseEntity<ResponseBase<ArticleDto>> changeStatusArticle(@Valid @ParameterObject ChangeArticleStatusRequest request) {
            return ResponseEntity.ok(new ResponseBase<>(articleService.changeStatusArticle(request)));
    }
    @Operation(
        summary = "Get All Article với filter ",
        description = "- Get All Article với filter"
    )
    @GetMapping("/getAll")
    public ResponseEntity<ResponseBase<List<ArticleDto>>> findAllArticle(@ParameterObject GetAllArticleRequest request) {
        return ResponseEntity.ok(new ResponseBase<>(articleService.getAllArticle(request)));
    }   @Operation(
        summary = "Get Detail Article ",
        description = "- Get Detail Article "
    )
    @GetMapping("/getDetail")
    public ResponseEntity<ResponseBase<ArticleDto>> getDetail(@Parameter Long id ) {
        return ResponseEntity.ok(new ResponseBase<>(articleService.getDetailArticle(id)));
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
