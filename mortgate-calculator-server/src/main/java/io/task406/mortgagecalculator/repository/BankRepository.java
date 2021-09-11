package io.task406.mortgagecalculator.repository;

import org.springframework.data.repository.CrudRepository;

import io.task406.mortgagecalculator.model.Bank;


public interface BankRepository extends CrudRepository<Bank, Long> {
}
