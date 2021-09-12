package io.task406.mortgagecalculator.controller;

import java.util.Collection;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.task406.mortgagecalculator.model.Bank;
import io.task406.mortgagecalculator.repository.BankRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class BankController {
    private final BankRepository bankRepository;

    @Autowired
    public BankController(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @GetMapping("/banks")
    Collection<Bank> getAllBanks() {
        return (Collection<Bank>) bankRepository.findAll();
    }

    @PostMapping("/banks")
    ResponseEntity<Bank> createBank(@Valid @RequestBody Bank bank) {
        Bank result = bankRepository.save(bank);
        return ResponseEntity.ok().body(result);
    }
}
