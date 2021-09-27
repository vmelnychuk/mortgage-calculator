package io.task406.mortgagecalculator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.task406.mortgagecalculator.model.Bank;
import io.task406.mortgagecalculator.model.PaymentCalculation;

@Repository
public interface PaymentCalculationRepository extends JpaRepository<PaymentCalculation, Long> {
    List<PaymentCalculation> findAllByBank(Bank bank);
}
