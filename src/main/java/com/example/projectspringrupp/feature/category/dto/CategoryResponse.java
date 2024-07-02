package com.example.projectspringrupp.feature.category.dto;

import com.example.projectspringrupp.feature.product.dto.ProductResponse;
import lombok.Builder;

import java.util.List;
@Builder
public record CategoryResponse(
        String categoryName,
        List<ProductResponse> products
) {
}
