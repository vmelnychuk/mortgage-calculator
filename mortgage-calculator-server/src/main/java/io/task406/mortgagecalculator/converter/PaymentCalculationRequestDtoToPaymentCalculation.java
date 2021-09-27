package io.task406.mortgagecalculator.converter;

import static io.task406.mortgagecalculator.common.Constants.BANK_NOT_FOUND_MESSAGE;
import static io.task406.mortgagecalculator.common.Constants.TOO_BIG_LOAN_AMOUNT_MESSAGE;
import static io.task406.mortgagecalculator.common.Constants.TOO_SMALL_DOWN_PAYMENT_AMOUNT_MESSAGE;

import java.math.BigDecimal;
import java.math.MathContext;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import io.task406.mortgagecalculator.dto.PaymentCalculationRequestDto;
import io.task406.mortgagecalculator.exception.BankNotFoundException;
import io.task406.mortgagecalculator.exception.TooBigLoanAmountException;
import io.task406.mortgagecalculator.exception.TooSmallDownPaymentException;
import io.task406.mortgagecalculator.model.Bank;
import io.task406.mortgagecalculator.model.PaymentCalculation;
import io.task406.mortgagecalculator.repository.BankRepository;

@Component
public class PaymentCalculationRequestDtoToPaymentCalculation implements Converter<PaymentCalculationRequestDto, PaymentCalculation> {
    private final BankRepository bankRepository;

    public PaymentCalculationRequestDtoToPaymentCalculation(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public PaymentCalculation convert(PaymentCalculationRequestDto request) {
        Long bankId = request.getBankId();
        Bank bank = bankRepository.findById(bankId)
            .orElseThrow(() ->
                new BankNotFoundException(String.format(BANK_NOT_FOUND_MESSAGE, bankId)));

        // check max amount
        BigDecimal maximumLoan = bank.getMaximumLoan();
        BigDecimal initialLoan = request.getInitialLoan();
        if (initialLoan.compareTo(maximumLoan) > 0) {
            throw new TooBigLoanAmountException(String.format(TOO_BIG_LOAN_AMOUNT_MESSAGE, initialLoan, maximumLoan));
        }

        // check down payment
        BigDecimal loan = request.getInitialLoan();
        BigDecimal downPayment = request.getDownPayment();
        BigDecimal minimumDownPayment = bank.getMinimumDownPayment();
        BigDecimal minimalDownPaymentForLoan = loan.multiply(minimumDownPayment.divide(BigDecimal.valueOf(100), MathContext.DECIMAL128));
        if (minimalDownPaymentForLoan.compareTo(downPayment) > 0) {
            throw new TooSmallDownPaymentException(String.format(TOO_SMALL_DOWN_PAYMENT_AMOUNT_MESSAGE, downPayment, minimalDownPaymentForLoan));
        }

        PaymentCalculation paymentCalculation = new PaymentCalculation();
        BeanUtils.copyProperties(request, paymentCalculation);
        paymentCalculation.setBank(bank);
        return paymentCalculation;
    }
}
