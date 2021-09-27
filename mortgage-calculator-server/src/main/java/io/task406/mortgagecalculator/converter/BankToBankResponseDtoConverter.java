package io.task406.mortgagecalculator.converter;

import io.task406.mortgagecalculator.dto.PaymentCalculationResponseDto;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import io.task406.mortgagecalculator.dto.BankResponseDto;
import io.task406.mortgagecalculator.model.Bank;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Component
public class BankToBankResponseDtoConverter implements Converter<Bank, BankResponseDto> {
    private final PaymentCalculationToPaymentCalculationResponseDto paymentConverter;

    @Autowired
    public BankToBankResponseDtoConverter(PaymentCalculationToPaymentCalculationResponseDto paymentConverter) {
        this.paymentConverter = paymentConverter;
    }

    @Override
    public BankResponseDto convert(Bank bank) {
        var response = new BankResponseDto();
        BeanUtils.copyProperties(bank, response);
        response.setLoanTerm((int) bank.getLoanTerm().toTotalMonths());
        List<PaymentCalculationResponseDto> paymentCalculations = Optional.ofNullable(bank.getPaymentCalculations())
            .map(Collection::stream)
            .orElseGet(Stream::empty)
            .map(payment -> paymentConverter.convert(payment))
            .toList();
        response.setPaymentCalculations(paymentCalculations);
        return response;
    }
}
