package io.task406.mortgagecalculator.common;

public class Constants {
    public static final int MAX_LOAN_TERM = 3600; // 300 years
    public static final long MAX_LOAN_AMOUNT = 10_000_000L; // one million
    public static final int MAX_ANNUAL_INTEREST_RATE = 1000; // 1000%
    public static final String BANK_NOT_FOUND_MESSAGE = "Bank with id '%s' is not found";
    public static final String TOO_BIG_LOAN_AMOUNT_MESSAGE = "Loan amount '%s' is bigger then bank limit '%s'";
    public static final String TOO_SMALL_DOWN_PAYMENT_AMOUNT_MESSAGE = "Offered down payment '%s' is smaller then minimal down payment '%s' for the bank";

}
