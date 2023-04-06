package com.example.goldenticketnew.service.category;

import com.example.goldenticketnew.model.Category;
import com.example.goldenticketnew.repository.ICategoryRepository;
import lombok.NoArgsConstructor;
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
    public Category createCategory() {
        return null;
    }

    @Override
    public Category updateCategory() {
        return null;
    }


}
