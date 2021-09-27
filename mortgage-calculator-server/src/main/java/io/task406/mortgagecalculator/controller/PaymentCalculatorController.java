package io.task406.mortgagecalculator.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.task406.mortgagecalculator.dto.PaymentCalculationRequestDto;
import io.task406.mortgagecalculator.dto.PaymentCalculationResponseDto;
import io.task406.mortgagecalculator.model.PaymentCalculation;
import io.task406.mortgagecalculator.service.PaymentCalculationService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/calculations")
@Api(tags = "Calculation Resource")
public class PaymentCalculatorController {
    private final PaymentCalculationService paymentCalculationService;
    private final ConversionService conversionService;

    @Autowired
    public PaymentCalculatorController(PaymentCalculationService paymentCalculationService, ConversionService conversionService) {
        this.paymentCalculationService = paymentCalculationService;
        this.conversionService = conversionService;
    }

    @PostMapping
    @ApiOperation(value = "Create new calculation")
    public ResponseEntity<PaymentCalculationResponseDto> calculateMonthlyPayment(@Valid @RequestBody PaymentCalculationRequestDto paymentCalculationRequestDto) {
        var calculation =
            paymentCalculationService.createPaymentCalculation(
                conversionService.convert(paymentCalculationRequestDto, PaymentCalculation.class));
        var calculationResponse = conversionService.convert(calculation, PaymentCalculationResponseDto.class);

        return ResponseEntity.ok(calculationResponse);
    }

    @GetMapping
    @ApiOperation(value = "Get all calculations")
    public ResponseEntity<List<PaymentCalculationResponseDto>> getCalculation(
        @RequestParam(name = "bankId", required = false) Optional<Long> bankId) {
        final List<PaymentCalculation> calculations;
        if (bankId.isPresent()) {
            calculations = paymentCalculationService.getCalculationsForBank(bankId.get());
        } else {
            calculations = paymentCalculationService.getAllCalculations();
        }

        var calculationsResponse = calculations.stream()
            .map(calculation -> conversionService.convert(calculation, PaymentCalculationResponseDto.class))
            .toList();

        return ResponseEntity.ok(calculationsResponse);
    }
}
