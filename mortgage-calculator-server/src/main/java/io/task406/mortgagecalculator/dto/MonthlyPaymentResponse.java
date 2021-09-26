package io.task406.mortgagecalculator.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MonthlyPaymentResponse {
    private BigDecimal monthlyPayment;
}
