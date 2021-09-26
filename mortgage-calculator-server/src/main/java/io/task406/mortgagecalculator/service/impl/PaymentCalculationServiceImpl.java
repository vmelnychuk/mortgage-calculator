package io.task406.mortgagecalculator.service.impl;

import static io.task406.mortgagecalculator.common.Constants.BANK_NOT_FOUND_MESSAGE;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.task406.mortgagecalculator.exception.BankNotFoundException;
import io.task406.mortgagecalculator.model.Bank;
import io.task406.mortgagecalculator.model.PaymentCalculation;
import io.task406.mortgagecalculator.repository.BankRepository;
import io.task406.mortgagecalculator.repository.PaymentCalculationRepository;
import io.task406.mortgagecalculator.service.MortgageCalculator;
import io.task406.mortgagecalculator.service.PaymentCalculationService;

@Service
public class PaymentCalculationServiceImpl implements PaymentCalculationService {
    private final PaymentCalculationRepository paymentCalculationRepository;
    private final BankRepository bankRepository;
    private final MortgageCalculator mortgageCalculator;

    @Autowired
    public PaymentCalculationServiceImpl(PaymentCalculationRepository paymentCalculationRepository,
                                         BankRepository bankRepository,
                                         MortgageCalculator mortgageCalculator) {
        this.paymentCalculationRepository = paymentCalculationRepository;
        this.bankRepository = bankRepository;
        this.mortgageCalculator = mortgageCalculator;
    }

    @Override
    public PaymentCalculation createPaymentCalculation(PaymentCalculation paymentCalculation) {
        BigDecimal amountBorrowed = paymentCalculation.getInitialLoan();
        BigDecimal annualInterestRate = paymentCalculation.getBank().getInterestRate();
        int numberOfMonthlyPayments = (int) paymentCalculation.getBank().getLoanTerm().toTotalMonths();
        BigDecimal monthlyPayment = mortgageCalculator
            .calculateMonthlyPayment(amountBorrowed, annualInterestRate, numberOfMonthlyPayments);
        paymentCalculation.setMonthlyPayment(monthlyPayment);
        paymentCalculation.setId(null);

        return paymentCalculationRepository.save(paymentCalculation);
    }

    @Override
    public List<PaymentCalculation> getCalculationsForBank(Long bankId) {
        Optional<Bank> bank = bankRepository.findById(bankId);
        return paymentCalculationRepository.findAllByBank(
            bank.orElseThrow(
                () -> new BankNotFoundException(String.format(BANK_NOT_FOUND_MESSAGE, bankId)))
        );
    }

    @Override
    public List<PaymentCalculation> getAllCalculations() {
        return paymentCalculationRepository.findAll();
    }
}
