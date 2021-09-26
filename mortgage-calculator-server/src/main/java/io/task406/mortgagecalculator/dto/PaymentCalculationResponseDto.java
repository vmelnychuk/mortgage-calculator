package io.task406.mortgagecalculator.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentCalculationResponseDto {
    private Long id;
    private BigDecimal monthlyPayment;
}
