package io.task406.mortgagecalculator.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCalculationResponseDto {
    private Long id;
    private BigDecimal monthlyPayment;
    private BigDecimal initialLoan;
    private BigDecimal downPayment;
}
