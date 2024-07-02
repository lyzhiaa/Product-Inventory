package com.example.projectspringrupp.feature.category.dto;

import com.example.projectspringrupp.feature.product.dto.ProductResponse;

import java.util.List;

public record CategoryResponse(
        String categoryName,
        List<ProductResponse> products
) {
}
