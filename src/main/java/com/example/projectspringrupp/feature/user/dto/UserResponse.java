package com.example.projectspringrupp.feature.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

public record UserResponse(
        String firstname,
        String lastname,
        String userPhone,
        String email
) {
}
