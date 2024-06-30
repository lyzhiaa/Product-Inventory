package com.example.projectspringrupp.feature.user.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record UserCreateRequest(
        @NotBlank(message = "Firstname is require!")
        String firstname,
        @NotBlank(message = "Lastname is require!")
        String lastname,
        @NotBlank(message = "Phone number is require!")
        String userPhone,
        @NotBlank(message = "Email is require!")
        String email,
        @NotBlank(message = "Password is require!")
                @Min(8)
        String password
) {
}
