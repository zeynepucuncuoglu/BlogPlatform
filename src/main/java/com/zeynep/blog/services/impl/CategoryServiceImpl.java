package com.zeynep.blog.services.impl;

import com.zeynep.blog.domain.entities.Category;
import com.zeynep.blog.repositories.CategoryRepository;
import com.zeynep.blog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }

    @Override
    public Category createCategory(Category category) {

        String categoryName = category.getName();
        if(categoryRepository.existsByNameIgnoreCase(categoryName)){
            throw new IllegalArgumentException("Category name already exist!!");
        }
        return categoryRepository.save(category);
    }
}
