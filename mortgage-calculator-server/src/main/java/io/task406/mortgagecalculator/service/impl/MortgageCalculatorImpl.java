package io.task406.mortgagecalculator.service.impl;

import java.math.BigDecimal;
import java.math.MathContext;

import org.springframework.stereotype.Service;

import io.task406.mortgagecalculator.service.MortgageCalculator;

@Service
public class MortgageCalculatorImpl implements MortgageCalculator {
    private static final int MONTHS_IN_YEAR = 12;
    private static final MathContext PRECISION_RATE = MathContext.DECIMAL128;

    @Override
    public BigDecimal calculateMonthlyPayment(BigDecimal amountBorrowed, BigDecimal annualInterestRatePercentage, int numberOfMonthlyPayments) {
        if (annualInterestRatePercentage.compareTo(BigDecimal.ZERO) == 0) {
            return amountBorrowed.divide(BigDecimal.valueOf(numberOfMonthlyPayments), PRECISION_RATE);
        } else {
            BigDecimal annualInterestRate = annualInterestRatePercentage.divide(BigDecimal.valueOf(100), PRECISION_RATE);
            BigDecimal monthlyInterestRate = annualInterestRate.divide(BigDecimal.valueOf(MONTHS_IN_YEAR), PRECISION_RATE);
            BigDecimal partInPower = BigDecimal.ONE.add(monthlyInterestRate).pow(numberOfMonthlyPayments);
            BigDecimal dividend = amountBorrowed.multiply(monthlyInterestRate).multiply(partInPower);
            BigDecimal divisor = partInPower.subtract(BigDecimal.ONE);
            return dividend.divide(divisor, PRECISION_RATE);
        }
    }
}
