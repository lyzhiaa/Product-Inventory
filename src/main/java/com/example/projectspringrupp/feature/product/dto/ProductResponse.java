package com.example.projectspringrupp.feature.product.dto;

import java.math.BigDecimal;

public record ProductResponse(
        String productName,
        String description,
        Integer quantity,
        BigDecimal basePrice,
        BigDecimal salePrice
) {
}
