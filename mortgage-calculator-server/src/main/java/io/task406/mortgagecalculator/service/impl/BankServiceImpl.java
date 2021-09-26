package io.task406.mortgagecalculator.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import io.task406.mortgagecalculator.exception.BankNotFoundException;
import io.task406.mortgagecalculator.model.Bank;
import io.task406.mortgagecalculator.repository.BankRepository;
import io.task406.mortgagecalculator.service.BankService;

@Service
public class BankServiceImpl implements BankService {
    private final BankRepository bankRepository;

    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public Bank addBank(Bank bank) {
        bank.setId(null);
        return bankRepository.save(bank);
    }

    @Override
    public Bank getBank(Long id) {
        return bankRepository.findById(id)
            .orElseThrow(() -> new BankNotFoundException(String.format("Bank with id '%s' is not found", id)));
    }

    @Override
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    @Override
    public Bank updateBank(Bank bank) {
        if (bankRepository.existsById(bank.getId())) {
            return bankRepository.save(bank);
        } else {
            throw new BankNotFoundException(String.format("Bank with id '%s' is not found", bank.getId()));
        }
    }

    @Override
    public void deleteBank(Long id) {
        if (bankRepository.existsById(id)) {
            bankRepository.deleteById(id);
        }
    }
}
