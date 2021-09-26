package io.task406.mortgagecalculator.exception;

public class TooSmallDownPaymentException extends RuntimeException {
    public TooSmallDownPaymentException(String message) {
        super(message);
    }
}
