package io.task406.mortgagecalculator.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.task406.mortgagecalculator.dto.MonthlyPaymentRequest;
import io.task406.mortgagecalculator.dto.MonthlyPaymentResponse;
import io.task406.mortgagecalculator.model.Bank;
import io.task406.mortgagecalculator.service.BankService;
import io.task406.mortgagecalculator.service.MorganCalculator;
import io.task406.mortgagecalculator.service.MortgageCalculatorService;

@Service
public class MortgageCalculatorServiceImpl implements MortgageCalculatorService {
    private final BankService bankService;
    private final MorganCalculator morganCalculator;

    @Autowired
    public MortgageCalculatorServiceImpl(BankService bankService, MorganCalculator morganCalculator) {
        this.bankService = bankService;
        this.morganCalculator = morganCalculator;
    }

    @Override
    public MonthlyPaymentResponse calculateMonthlyPayment(MonthlyPaymentRequest monthlyPaymentRequest) {
        Bank bank = bankService.getBank(monthlyPaymentRequest.getBankId());
        BigDecimal amountBorrowed = monthlyPaymentRequest.getInitialLoan();
        BigDecimal annualInterestRate = bank.getInterestRate();
        int numberOfMonthlyPayments = bank.getLoanTerm().getMonths();
        BigDecimal monthlyPayment = calculateMonthlyPayment(amountBorrowed, annualInterestRate, numberOfMonthlyPayments);
        return MonthlyPaymentResponse.builder()
            .monthlyPayment(monthlyPayment)
            .build();
    }

    private BigDecimal calculateMonthlyPayment(BigDecimal amountBorrowed, BigDecimal annualInterestRate, int numberOfMonthlyPayments) {
        return morganCalculator.calculateMonthlyPayment(amountBorrowed, annualInterestRate, numberOfMonthlyPayments);
    }
}
