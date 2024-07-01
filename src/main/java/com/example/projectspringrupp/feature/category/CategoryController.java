package com.example.projectspringrupp.feature.category;

import com.example.projectspringrupp.feature.category.dto.CategoryCreateRequest;
import com.example.projectspringrupp.feature.category.dto.CategoryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;
    //create Category
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    CategoryResponse createNewCategory(@Valid @RequestBody CategoryCreateRequest categoryCreateRequest) {
        return categoryService.createCategory(categoryCreateRequest);
    }
    //find single Category
    @GetMapping("/{name}")
    CategoryResponse findCategoryName(@Valid @PathVariable String name) {
        return categoryService.findCategoryByName(name);
    }

    //find all Category
    @GetMapping
    List<CategoryResponse> findAllCategory(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size) {
        return categoryService.findAllCategory(page, size);
    }

    //update Category
    @PatchMapping("/{name}")
    CategoryResponse updateByName(@Valid @PathVariable String name, @RequestBody CategoryCreateRequest categoryCreateRequest) {
        return categoryService.UpdateCategory(name, categoryCreateRequest);
    }

    //delete Category
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{name}")
    void deleteByName(@Valid @PathVariable String name) {
        categoryService.deleteCategory(name);
    }
}
