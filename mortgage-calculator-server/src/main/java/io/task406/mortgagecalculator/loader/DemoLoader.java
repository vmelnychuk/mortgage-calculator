package io.task406.mortgagecalculator.loader;

import java.math.BigDecimal;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.task406.mortgagecalculator.model.Bank;
import io.task406.mortgagecalculator.repository.BankRepository;

@Component
public class DemoLoader implements CommandLineRunner {
    private final BankRepository bankRepository;

    @Autowired
    public DemoLoader(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public void run(String... args) {
//        this.bankRepository.save(
//            Bank.builder()
//                .name("Simple Bank")
//                .interestRate(BigDecimal.valueOf(30))
//                .maximumLoan(BigDecimal.valueOf(1000000))
//                .minimumDownPayment(BigDecimal.valueOf(10))
//                .loanTerm(Period.ofYears(1))
//                .build()
//        );
    }
}
