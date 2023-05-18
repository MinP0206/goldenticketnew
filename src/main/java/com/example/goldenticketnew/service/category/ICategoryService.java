package com.example.goldenticketnew.service.category;

import com.example.goldenticketnew.dtos.CategoryDto;
import com.example.goldenticketnew.model.Category;
import com.example.goldenticketnew.payload.GetAllCateRequest;
import com.example.goldenticketnew.payload.response.ApiResponse;
import com.example.goldenticketnew.payload.response.PageResponse;


import java.util.List;

public interface ICategoryService {
    List<CategoryDto> getAllCategory(GetAllCateRequest request) ;

    Category getOneCategory(Long id);
    CategoryDto createCategory(String name) ;
    ApiResponse deleteCategory(Long id);
    Category updateCategory() ;
}
