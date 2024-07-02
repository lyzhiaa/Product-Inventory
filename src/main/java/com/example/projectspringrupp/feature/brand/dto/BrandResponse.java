package com.example.projectspringrupp.feature.brand.dto;

import com.example.projectspringrupp.domain.Product;
import lombok.Builder;

import java.util.List;
@Builder
public record BrandResponse(
        String brandName
) {
}
