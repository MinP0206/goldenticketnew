package com.example.goldenticketnew.service.category;

import com.example.goldenticketnew.model.Category;
import com.example.goldenticketnew.payload.UserSummary;
import com.example.goldenticketnew.security.CurrentUser;
import com.example.goldenticketnew.security.UserPrincipal;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategory() ;

    Category getOneCategory(Long id);
    Category createCategory(String name) ;
    Category updateCategory() ;
}
