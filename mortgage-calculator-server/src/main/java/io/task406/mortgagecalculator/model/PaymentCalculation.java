package io.task406.mortgagecalculator.model;

import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentCalculation {
    @Id
    @GeneratedValue
    private Long id;
    private BigDecimal initialLoan;
    private BigDecimal downPayment;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    private Bank bank;
    private BigDecimal monthlyPayment;
}
