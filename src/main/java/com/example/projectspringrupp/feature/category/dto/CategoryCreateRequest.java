package com.example.projectspringrupp.feature.category.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CategoryCreateRequest(
        @NotBlank(message = "Category name is require!")
        String categoryName
){
}
