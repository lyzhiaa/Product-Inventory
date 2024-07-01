package com.example.projectspringrupp.feature.category;

import com.example.projectspringrupp.feature.category.dto.CategoryCreateRequest;
import com.example.projectspringrupp.feature.category.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {
    // Create Category
    CategoryResponse createCategory(CategoryCreateRequest categoryCreateRequest);
    //find all Category
    List<CategoryResponse> findAllCategory(int page, int size);
    // find Category by name
    CategoryResponse findCategoryByName(String categoryName);
    // Update Category
    CategoryResponse UpdateCategory(String categoryName, CategoryCreateRequest categoryCreateRequest);
    // Delete Category
    void deleteCategory(String categoryName);
}
