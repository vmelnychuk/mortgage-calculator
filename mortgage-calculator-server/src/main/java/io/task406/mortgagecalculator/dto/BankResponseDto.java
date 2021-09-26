package io.task406.mortgagecalculator.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class BankResponseDto {
    private Long id;
    private String name;
    private BigDecimal interestRate;
    private BigDecimal maximumLoan;
    private BigDecimal minimumDownPayment;
    private int loanTerm;
}
