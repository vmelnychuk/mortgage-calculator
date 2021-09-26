package io.task406.mortgagecalculator.model;

import java.math.BigDecimal;
import java.time.Period;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bank {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    /**
     * in percentage e.g. 10%, 20%
     */
    private BigDecimal interestRate;
    private BigDecimal maximumLoan;
    /**
     * in percentage e.g. 10%, 20%
     */
    private BigDecimal minimumDownPayment;
    private Period loanTerm;
}
