package io.task406.mortgagecalculator.exception;

public class TooBigLoanAmountException extends RuntimeException {
    public TooBigLoanAmountException(String message) {
        super(message);
    }
}
