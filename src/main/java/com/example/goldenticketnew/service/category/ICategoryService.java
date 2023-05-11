package com.example.goldenticketnew.service.category;

import com.example.goldenticketnew.dtos.CategoryDto;
import com.example.goldenticketnew.model.Category;


import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategory() ;

    Category getOneCategory(Long id);
    CategoryDto createCategory(String name) ;
    Category updateCategory() ;
}
