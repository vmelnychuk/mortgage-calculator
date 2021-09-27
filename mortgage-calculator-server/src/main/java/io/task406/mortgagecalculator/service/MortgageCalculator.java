package io.task406.mortgagecalculator.service;

import java.math.BigDecimal;

public interface MortgageCalculator {
    /**
     * Calculates monthly payment.
     *
     * @param amountBorrowed               amount of borrowed money
     * @param annualInterestRatePercentage in percentage e.g. 10%, 20%
     * @param numberOfMonthlyPayments      number of month for payment
     * @return monthly payment amount
     */
    BigDecimal calculateMonthlyPayment(BigDecimal amountBorrowed, BigDecimal annualInterestRatePercentage, int numberOfMonthlyPayments);
}
