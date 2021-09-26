package io.task406.mortgagecalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.task406.mortgagecalculator.dto.MonthlyPaymentRequest;
import io.task406.mortgagecalculator.dto.MonthlyPaymentResponse;
import io.task406.mortgagecalculator.service.MortgageCalculatorService;

@RestController
@RequestMapping("/api/calculator")
public class MortgageCalculatorController {
    private final MortgageCalculatorService mortgageCalculatorService;

    @Autowired
    public MortgageCalculatorController(MortgageCalculatorService mortgageCalculatorService) {
        this.mortgageCalculatorService = mortgageCalculatorService;
    }

    @PostMapping("/")
    public MonthlyPaymentResponse calculateMonthlyPayment(@RequestBody MonthlyPaymentRequest monthlyPaymentRequest) {
        return mortgageCalculatorService.calculateMonthlyPayment(monthlyPaymentRequest);
    }
}
