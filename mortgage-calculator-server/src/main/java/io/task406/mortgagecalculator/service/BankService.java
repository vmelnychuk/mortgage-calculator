package io.task406.mortgagecalculator.service;

import java.util.List;

import io.task406.mortgagecalculator.model.Bank;

public interface BankService {
    Bank addBank(Bank bank);

    Bank getBank(Long id);

    List<Bank> getAllBanks();

    Bank updateBank(Bank bank);

    void deleteBank(Long id);
}
