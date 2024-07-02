package com.example.projectspringrupp.feature.product.dto;

import jakarta.persistence.Column;
import lombok.Builder;

import java.math.BigDecimal;
@Builder
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
