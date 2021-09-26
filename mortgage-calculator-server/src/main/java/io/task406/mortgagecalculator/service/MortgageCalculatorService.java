package io.task406.mortgagecalculator.service;

import io.task406.mortgagecalculator.dto.MonthlyPaymentRequest;
import io.task406.mortgagecalculator.dto.MonthlyPaymentResponse;

public interface MortgageCalculatorService {
    MonthlyPaymentResponse calculateMonthlyPayment(MonthlyPaymentRequest monthlyPaymentRequest);
}
