package io.task406.mortgagecalculator.dto;

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
    private Long id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @PositiveOrZero
    private BigDecimal interestRate;
    @Positive
    @Max(MAX_LOAN_AMOUNT)
    private BigDecimal maximumLoan;
    @PositiveOrZero
    private BigDecimal minimumDownPayment;
    @Positive
    @Max(MAX_LOAN_TERM)
    private int loanTerm;
}
