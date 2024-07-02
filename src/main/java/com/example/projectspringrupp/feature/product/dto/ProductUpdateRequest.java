package com.example.projectspringrupp.feature.product.dto;

import lombok.Builder;

import java.math.BigDecimal;
@Builder
public record ProductUpdateRequest(
        String productName,
        String description,
        Integer quantity,
        BigDecimal basePrice,
        BigDecimal salePrice
) {
}
