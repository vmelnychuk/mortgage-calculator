package io.task406.mortgagecalculator.service.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import io.task406.mortgagecalculator.service.MortgageCalculator;

class MortgageCalculatorImplTest {
    private final MortgageCalculator mortgageCalculator = new MortgageCalculatorImpl();

    @ParameterizedTest
    @CsvSource({
        "100,120,1,110",
        "100,0,1,100"
    })
    void calculateMonthlyPaymentWithParams(String amount, String percentage, String months, String expectedPayment) {
        BigDecimal amountBorrowed = new BigDecimal(amount);
        BigDecimal annualInterestRate = new BigDecimal(percentage);
        int numberOfMonthlyPayments = Integer.parseInt(months);
        BigDecimal expectedPaymentAmount = new BigDecimal(expectedPayment);

        BigDecimal monthlyPayment = mortgageCalculator.calculateMonthlyPayment(amountBorrowed, annualInterestRate, numberOfMonthlyPayments);

        assertThat(monthlyPayment, comparesEqualTo(expectedPaymentAmount));
    }

    @Test
    void calculateMonthlyPayment() {
        BigDecimal amountBorrowed = BigDecimal.valueOf(45000);
        BigDecimal annualInterestRate = BigDecimal.valueOf(5);
        int numberOfMonthlyPayments = 3;
        BigDecimal expectedPaymentAmount = new BigDecimal(110);

        BigDecimal monthlyPayment = mortgageCalculator.calculateMonthlyPayment(amountBorrowed, annualInterestRate, numberOfMonthlyPayments);

        assertThat(monthlyPayment, comparesEqualTo(expectedPaymentAmount));
    }
}
