package com.example.projectspringrupp.feature.product.dto;

import jakarta.persistence.Column;

import java.math.BigDecimal;

public record ProductCreateRequest(
        String productName,
        String description,
        Integer quantity,
        BigDecimal basePrice,
        BigDecimal salePrice,
        String brandName,
        String categoryName,

        Long userId,

        String supplierName
) {
}
