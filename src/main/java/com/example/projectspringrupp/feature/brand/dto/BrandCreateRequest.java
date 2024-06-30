package com.example.projectspringrupp.feature.brand.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record BrandCreateRequest (
        @NotBlank(message = "Brand name is require!")
        String brandName
){
}
