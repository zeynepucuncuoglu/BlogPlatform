package com.zeynep.blog.services;

import com.zeynep.blog.domain.entities.Category;

import java.util.List;

public interface CategoryService {

    List<Category> listCategories();
    Category createCategory(Category categoryToCreate);
}
