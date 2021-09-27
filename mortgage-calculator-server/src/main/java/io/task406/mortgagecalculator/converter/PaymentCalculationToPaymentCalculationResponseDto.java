package io.task406.mortgagecalculator.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import io.task406.mortgagecalculator.dto.PaymentCalculationResponseDto;
import io.task406.mortgagecalculator.model.PaymentCalculation;

@Component
public class PaymentCalculationToPaymentCalculationResponseDto implements Converter<PaymentCalculation, PaymentCalculationResponseDto> {
    @Override
    public PaymentCalculationResponseDto convert(PaymentCalculation paymentCalculation) {
        var response = new PaymentCalculationResponseDto();
        BeanUtils.copyProperties(paymentCalculation, response);
        return response;
    }
}
