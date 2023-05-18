package com.example.goldenticketnew.controller;

import com.example.goldenticketnew.dtos.ArticleDto;
import com.example.goldenticketnew.dtos.ArticleReportDto;
import com.example.goldenticketnew.dtos.CategoryDto;
import com.example.goldenticketnew.enums.ArticleStatus;
import com.example.goldenticketnew.enums.ArticleType;
import com.example.goldenticketnew.model.Category;
import com.example.goldenticketnew.payload.GetAllCateRequest;
import com.example.goldenticketnew.payload.article.request.*;
import com.example.goldenticketnew.payload.response.ApiResponse;
import com.example.goldenticketnew.payload.response.PageResponse;
import com.example.goldenticketnew.payload.response.ResponseBase;
import com.example.goldenticketnew.security.CurrentUser;
import com.example.goldenticketnew.security.UserPrincipal;
import com.example.goldenticketnew.service.article.IArticleService;
import com.example.goldenticketnew.service.category.ICategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/article")
@RequiredArgsConstructor
@Tag(name = "Article Controller", description = "Thao tác với các bài đăng")
public class ArticleController {
    private final IArticleService articleService;

    private final ICategoryService categoryService;
    @Operation(
        summary = "[NEWS WEBSITE] Thêm mới bai viet co cate của User ",
        description = "- Thêm mới bai viet của User"
    )
    @PostMapping("/addNewArticle")
    public ResponseEntity<ResponseBase<ArticleDto>> addNewArticleNEWS(@Valid @RequestBody AddNewArRequest request) {
        request.setType(ArticleType.NEWS);
        return ResponseEntity.ok(new ResponseBase<>(articleService.addNewArticleNews(request)));
    }
    @Operation(
        summary = "Thêm mới Draft bản nháp co cate của User ",
        description = "- Thêm mới bai viet của User"
    )
    @PostMapping("/addNewDraft")
    public ResponseEntity<ResponseBase<ArticleDto>> addNewArticleDraft(@Valid @RequestBody AddNewArRequest request) {
        request.setStatus(ArticleStatus.DRAFT);
        request.setType(ArticleType.NEWS);
        return ResponseEntity.ok(new ResponseBase<>(articleService.addNewArticleNews(request)));
    }
    @Operation(
        summary = "Chuyển từ bản nháp sang bản chính thức bài viết ",
        description = "- Chuyển từ bản nháp sang bản chính thức bài viết"
    )
    @PostMapping("/publicDraft")
    public ResponseEntity<ResponseBase<ArticleDto>> addNewDraftPublic(@Valid @Parameter long draftId) {

        return ResponseEntity.ok(new ResponseBase<>(articleService.publicDraft(draftId)));
    }

    @Operation(
        summary = "Thêm mới Review của User ",
        description = "- Thêm mới Review của User"
    )
    @PostMapping("/addNewReview")
    public ResponseEntity<ResponseBase<ArticleDto>> addNewArticleReview(@Valid @RequestBody AddNewReviewRequest request) {
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
    public ResponseEntity<ResponseBase<ArticleDto>> updateArticle( @RequestBody UpdateArticleRequest request) {
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
    summary = "Get Detail Article by ( slug) ",
    description = "- Get Detail Article by (slug) "
)
@GetMapping("/getDetail/{slug}")
public ResponseEntity<ResponseBase<ArticleDto>> getDetailByTitle(@PathVariable String slug ) {
    return ResponseEntity.ok(new ResponseBase<>(articleService.getArticleBySLug(slug)));
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

    @Operation(
        summary = "Get All Article với filter và paging ",
        description = "- Get All Article với filter và paging"
    )
    @GetMapping("/v2/getAllPaging")
    public ResponseBase<PageResponse<ArticleDto>> findAllArticlePagingV2(@ParameterObject Pageable pageable, @ParameterObject GetAllArticleRequest request) {
        request.setPageable(pageable);
        return new ResponseBase<>(articleService.getAllArticlePagingV2(request));
    }

    @Operation(
        summary = "Thêm mới Category",
        description = "Thêm mới Category"
    )
    @PostMapping("/category/add")
    public ResponseEntity<ResponseBase<CategoryDto>> addCategory(@Valid @ParameterObject AddNewCategory request) {
        return ResponseEntity.ok(new ResponseBase<>(categoryService.createCategory(request.getCategoryName())));
    }
    @Operation(
        summary = "Xoá Category không được sử dụng",
        description = "Xoá Category không được sử dụng(cate đang được sử dụng không được xóa)"
    )
    @DeleteMapping("/category/delete/{id}")
    public ResponseEntity<ApiResponse> removeCategory(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.deleteCategory(id));
    }
    @Operation(
        summary = "Get All Category",
        description = "Get All Category"
    )
    @GetMapping("/category/getAll")
    public ResponseEntity<ResponseBase<List<CategoryDto>>> getAllCate( @ParameterObject GetAllCateRequest request) {
        return ResponseEntity.ok(new ResponseBase<>(categoryService.getAllCategory(request)));
    }
    @Operation(
        summary = "Get All Category For User",
        description = "Get All Category For User"
    )
    @GetMapping("/user/getAll")
    public ResponseEntity<ResponseBase<List<ArticleDto>>> getAllCateByUser(@CurrentUser UserPrincipal currentUser, @Parameter ArticleStatus status) {
        return ResponseEntity.ok(new ResponseBase<>(articleService.getAllByUser(currentUser, status)));
    }
    @Operation(
        summary = "Get Report user and article",
        description = "Get Report user and article"
    )
    @GetMapping("/user/getAllReport")
    public ResponseEntity<ResponseBase<ArticleReportDto>> getReportUser(@Parameter String dateTime) {
        return ResponseEntity.ok(new ResponseBase<>(articleService.getReport(dateTime)));
    }

    @Operation(
        summary = "Thêm bài viết lưu trữ ( yêu thích) của user",
        description = "- Thêm bài viết lưu trữ ( yêu thích) của user"
    )
    @PostMapping("/user/addSaveArticle")
    public ResponseEntity<ResponseBase<List<ArticleDto>>> addNewArticleinUser(@Valid @Parameter Long userId, @Parameter Long articleId) {
        return ResponseEntity.ok(new ResponseBase<>(articleService.addNewArticleInuser(userId,articleId)));
    }
    @Operation(
        summary = "Gỡ bài viết lưu trữ ( yêu thích) của user",
        description = "- Gỡ bài viết lưu trữ ( yêu thích) của user"
    )
    @PostMapping("/user/removeSaveArticle")
    public ResponseEntity<ResponseBase<List<ArticleDto>>> removeArticleinUser(@Valid @Parameter Long userId, @Parameter Long articleId) {
        return ResponseEntity.ok(new ResponseBase<>(articleService.removeArticleInuser(userId,articleId)));
    }

    @Operation(
        summary = "Get All Category lưu trữ( yêu thích của user)",
        description = "Get All Category lưu trữ( yêu thích của user)"
    )
    @GetMapping("/user/saveArticle/getAll")
    public ResponseEntity<ResponseBase<PageResponse<ArticleDto>>> getAllCateByUser(@Parameter Long userId, @ParameterObject Pageable pageable) {
        return ResponseEntity.ok(new ResponseBase<>(articleService.getAllArticlePagingInUser(userId,pageable)));
    }
}
