package io.task406.mortgagecalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.task406.mortgagecalculator.model.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
