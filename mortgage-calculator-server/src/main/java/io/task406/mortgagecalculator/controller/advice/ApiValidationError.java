package io.task406.mortgagecalculator.controller.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ApiValidationError extends ApiSubError {
    private String field;
    private Object rejectedValue;
    private String message;

    ApiValidationError(String message) {
        this.message = message;
    }
}
