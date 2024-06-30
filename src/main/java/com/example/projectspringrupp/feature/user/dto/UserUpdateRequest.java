package com.example.projectspringrupp.feature.user.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record UserUpdateRequest(
        @NotBlank(message = "Phone is require!")
        String userPhone,
        @NotBlank(message = "Email is require!")
        String email,
        @NotBlank(message = "Password is require!")
        @Min(8)
        String password
) {
}
