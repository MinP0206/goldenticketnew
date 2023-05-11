package com.example.goldenticketnew.service.category;

import com.example.goldenticketnew.dtos.CategoryDto;
import com.example.goldenticketnew.model.Category;
import com.example.goldenticketnew.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService implements ICategoryService{
    private final ICategoryRepository categoryRepository;


    @Override
    public List<Category> getAllCategory() {
        try{
            return categoryRepository.findAll();
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
    public Category updateCategory() {
        return null;
    }


}
