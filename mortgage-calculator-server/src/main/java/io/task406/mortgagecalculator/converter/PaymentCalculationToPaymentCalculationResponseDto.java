package io.task406.mortgagecalculator.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import io.task406.mortgagecalculator.dto.PaymentCalculationResponseDto;
import io.task406.mortgagecalculator.model.PaymentCalculation;

@Component
public class PaymentCalculationToPaymentCalculationResponseDto implements Converter<PaymentCalculation, PaymentCalculationResponseDto> {
    @Override
    public PaymentCalculationResponseDto convert(PaymentCalculation paymentCalculation) {
        var response = PaymentCalculationResponseDto.builder()
            .id(paymentCalculation.getId())
            .monthlyPayment(paymentCalculation.getMonthlyPayment())
            .build();
        return response;
    }
}
