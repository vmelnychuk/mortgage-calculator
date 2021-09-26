package io.task406.mortgagecalculator.service;

import java.util.List;

import io.task406.mortgagecalculator.model.PaymentCalculation;

public interface PaymentCalculationService {
    PaymentCalculation createPaymentCalculation(PaymentCalculation paymentCalculation);

    List<PaymentCalculation> getCalculationsForBank(Long bankId);

    List<PaymentCalculation> getAllCalculations();
}
