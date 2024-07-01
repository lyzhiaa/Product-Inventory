package com.example.projectspringrupp.feature.category;

import com.example.projectspringrupp.domain.Category;
import com.example.projectspringrupp.feature.category.dto.CategoryCreateRequest;
import com.example.projectspringrupp.feature.category.dto.CategoryResponse;
import com.example.projectspringrupp.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    //Create Category
    @Override
    public CategoryResponse createCategory(CategoryCreateRequest categoryCreateRequest) {
// validate product name
        if (categoryRepository.existsByCategoryName(categoryCreateRequest.categoryName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "This category is already exist!");
        }
        // transfer DTO domain model
        Category category = categoryMapper.fromCategoryCreateRequest(categoryCreateRequest);
        category = categoryRepository.save(category);

        // system generate date
        category.setCategoryName(category.getCategoryName());

        // save product to database
        category = categoryRepository.save(category);

        return categoryMapper.toCategoryResponse(category);
    }


    //find all product
    @Override
    public List<CategoryResponse> findAllCategory(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Category> categories = categoryRepository.findAll(pageable);
        return categoryMapper.toCategoryResponseList(categories.getContent());
    }

    // find single product
    @Override
    public CategoryResponse findCategoryByName(String categoryName) {
        Category category = categoryRepository.findByCategoryName(categoryName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "This category is not found!"));
        return categoryMapper.toCategoryResponse(category);
    }

    // update brand
    @Override
    public CategoryResponse UpdateCategory(String categoryName, CategoryCreateRequest categoryCreateRequest) {
        Category category = categoryRepository.findByCategoryName(categoryName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "We can not find this category name."));
        categoryMapper.fromCategoryUpdateRequest(categoryCreateRequest, category);
        category = categoryRepository.save(category);
        return categoryMapper.toCategoryResponse(category);
    }

    // delete brand
    @Override
    public void deleteCategory(String categoryName) {
        Category category = categoryRepository.findByCategoryName(categoryName)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Can't delete this category because it is not found."));
        categoryRepository.delete(category);
    }
}
