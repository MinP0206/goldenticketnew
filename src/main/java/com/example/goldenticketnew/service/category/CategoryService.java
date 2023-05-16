package com.example.goldenticketnew.service.category;

import com.example.goldenticketnew.dtos.ArticleDto;
import com.example.goldenticketnew.dtos.CategoryDto;
import com.example.goldenticketnew.model.Category;
import com.example.goldenticketnew.payload.response.ApiResponse;
import com.example.goldenticketnew.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService implements ICategoryService{
    private final ICategoryRepository categoryRepository;


    @Override
    public List<CategoryDto> getAllCategory() {
        try{
            return categoryRepository.findAll().stream().map(CategoryDto::new).collect(Collectors.toList());
        }catch(Exception ex){
            log.error(ex.getMessage());
        }
        return  new ArrayList<>();
    }

    @Override
    public Category getOneCategory(Long id) {
        return categoryRepository.getById(id);
    }

    @Override
    public CategoryDto createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        category = categoryRepository.save(category);
        return new CategoryDto(category);
    }

    @Override
    public ApiResponse deleteCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isEmpty()) return new ApiResponse(false,"Cate not found!");
        categoryRepository.deleteById(id);
        return new ApiResponse(true,"Delete successfully!!");
    }

    @Override
    public Category updateCategory() {
        return null;
    }


}
