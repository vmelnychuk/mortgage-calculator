package io.task406.mortgagecalculator.dto;

import static io.task406.mortgagecalculator.common.Constants.MAX_ANNUAL_INTEREST_RATE;
import static io.task406.mortgagecalculator.common.Constants.MAX_LOAN_AMOUNT;
import static io.task406.mortgagecalculator.common.Constants.MAX_LOAN_TERM;

import java.math.BigDecimal;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankRequestDto {
    @Positive
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @PositiveOrZero
    @Max(MAX_ANNUAL_INTEREST_RATE)
    private BigDecimal interestRate;

    @NotNull
    @Positive
    @Max(MAX_LOAN_AMOUNT)
    private BigDecimal maximumLoan;

    @NotNull
    @PositiveOrZero
    @Max(100)
    private BigDecimal minimumDownPayment;

    @NotNull
    @Positive
    @Max(MAX_LOAN_TERM)
    private int loanTerm;
}
