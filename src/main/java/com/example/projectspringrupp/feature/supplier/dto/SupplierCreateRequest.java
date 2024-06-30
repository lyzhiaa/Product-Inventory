package com.example.projectspringrupp.feature.supplier.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record SupplierCreateRequest(
        @NotBlank(message = "First name is require!")
        String firstname,
        @NotBlank(message = "Last name is require!")
        String lastname,
        @NotBlank(message = "Phone is require!")
        String supplierPhone,
        @NotBlank(message = "Address is require!")
        String address
) {
}
