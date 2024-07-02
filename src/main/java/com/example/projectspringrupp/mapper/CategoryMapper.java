package com.example.projectspringrupp.mapper;

import com.example.projectspringrupp.domain.Brand;
import com.example.projectspringrupp.domain.Category;
import com.example.projectspringrupp.feature.brand.dto.BrandCreateRequest;
import com.example.projectspringrupp.feature.brand.dto.BrandResponse;
import com.example.projectspringrupp.feature.category.dto.CategoryCreateRequest;
import com.example.projectspringrupp.feature.category.dto.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "Spring", uses = {ProductMapper.class})
public interface CategoryMapper {
    @Mapping(target = "products", source = "product")
    CategoryResponse toCategoryResponse(Category category);
    Category fromCategoryCreateRequest(CategoryCreateRequest categoryCreateRequest);
    List<CategoryResponse> toCategoryResponseList(List<Category> categories);
    void fromCategoryUpdateRequest(CategoryCreateRequest categoryCreateRequest, @MappingTarget Category category);
}
