package com.example.projectspringrupp.feature.supplier.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record SupplierResponse (
        String firstname,
        String lastname,
        String supplierPhone,
        String address
){
}
