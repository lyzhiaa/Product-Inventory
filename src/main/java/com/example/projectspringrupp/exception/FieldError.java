package com.example.projectspringrupp.exception;

import lombok.Builder;

@Builder
public record FieldError(
        String field,
        String detail
) {
}
