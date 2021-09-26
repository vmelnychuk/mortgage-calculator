package io.task406.mortgagecalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.task406.mortgagecalculator.model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
}
