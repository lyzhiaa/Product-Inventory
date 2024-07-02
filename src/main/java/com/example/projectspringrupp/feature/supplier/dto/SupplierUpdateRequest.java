package com.example.projectspringrupp.feature.supplier.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record SupplierUpdateRequest (
        @NotBlank(message = "Phone is require!")
        String supplierPhone,
        @NotBlank(message = "Address is require!")
        String address
) {
}
