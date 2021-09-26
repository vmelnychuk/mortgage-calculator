package io.task406.mortgagecalculator.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class MonthlyPaymentRequest {
    private BigDecimal initialLoan;
    private BigDecimal downPayment;
    private Long bankId;
}
