package io.task406.mortgagecalculator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import io.task406.mortgagecalculator.model.Bank;

@CrossOrigin
public interface BankRepository extends CrudRepository<Bank, Long> {
}
