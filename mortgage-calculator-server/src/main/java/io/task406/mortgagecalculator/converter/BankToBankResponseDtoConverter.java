package io.task406.mortgagecalculator.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import io.task406.mortgagecalculator.dto.BankResponseDto;
import io.task406.mortgagecalculator.model.Bank;

@Component
public class BankToBankResponseDtoConverter implements Converter<Bank, BankResponseDto> {
    @Override
    public BankResponseDto convert(Bank bank) {
        var response = new BankResponseDto();
        BeanUtils.copyProperties(bank, response);
        response.setLoanTerm((int) bank.getLoanTerm().toTotalMonths());
        return response;
    }
}
