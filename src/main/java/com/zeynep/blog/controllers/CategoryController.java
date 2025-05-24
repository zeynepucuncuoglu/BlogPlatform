package com.zeynep.blog.controllers;

import com.zeynep.blog.domain.dtos.CategoryDto;
import com.zeynep.blog.domain.dtos.CreateCategoryRequest;
import com.zeynep.blog.domain.entities.Category;
import com.zeynep.blog.mappers.CategoryMapper;
import com.zeynep.blog.services.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.http11.filters.VoidInputFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(path = "/api/v1/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories(){
        List<CategoryDto> categories = categoryService.listCategories()
                .stream()
                .map(categoryMapper::toDto)
                .toList();

        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(
           @Valid @RequestBody CreateCategoryRequest createCategoryRequest
    ){
        Category categoryToCreate = categoryMapper.toEntity(createCategoryRequest);
        Category savedCategory = categoryService.createCategory(categoryToCreate);

        return new ResponseEntity<>(
                categoryMapper.toDto(savedCategory),
                HttpStatus.CREATED
                );
    }

    public ResponseEntity<Void> deleteCategory(@PathVariable UUID id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}