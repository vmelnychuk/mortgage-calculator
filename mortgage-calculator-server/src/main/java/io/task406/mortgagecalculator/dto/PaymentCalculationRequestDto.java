package io.task406.mortgagecalculator.dto;

import static io.task406.mortgagecalculator.common.Constants.MAX_LOAN_AMOUNT;

import java.math.BigDecimal;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import lombok.Data;

@Data
public class PaymentCalculationRequestDto {
    @Positive
    private Long id;

    @NotNull
    @Positive
    @Max(MAX_LOAN_AMOUNT)
    private BigDecimal initialLoan;

    @NotNull
    @PositiveOrZero
    @Max(MAX_LOAN_AMOUNT)
    private BigDecimal downPayment;

    @NotNull
    @Positive
    private Long bankId;
}
