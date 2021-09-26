package io.task406.mortgagecalculator.converter;

import java.time.Period;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import io.task406.mortgagecalculator.dto.BankRequestDto;
import io.task406.mortgagecalculator.model.Bank;

@Component
public class BankRequestDtoToBankConverter implements Converter<BankRequestDto, Bank> {
    @Override
    public Bank convert(BankRequestDto request) {
        var bank = new Bank();
        BeanUtils.copyProperties(request, bank);
        bank.setLoanTerm(Period.ofMonths(request.getLoanTerm()));
        return bank;
    }
}
