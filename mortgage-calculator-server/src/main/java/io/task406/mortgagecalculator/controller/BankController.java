package io.task406.mortgagecalculator.controller;

import java.util.List;
import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.task406.mortgagecalculator.dto.BankRequestDto;
import io.task406.mortgagecalculator.dto.BankResponseDto;
import io.task406.mortgagecalculator.exception.IdMismatchException;
import io.task406.mortgagecalculator.model.Bank;
import io.task406.mortgagecalculator.service.BankService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/banks")
@Api(tags = "Bank Resource")
public class BankController {

    private final BankService bankService;
    private final ConversionService conversionService;

    @Autowired
    public BankController(BankService bankService, ConversionService conversionService) {
        this.bankService = bankService;
        this.conversionService = conversionService;
    }

    @PostMapping
    @ApiOperation(value = "Create new bank")
    public ResponseEntity<BankResponseDto> createBank(@Valid @RequestBody BankRequestDto bankRequestDto) {
        var bank = bankService.addBank(conversionService.convert(bankRequestDto, Bank.class));
        var bankResponse = conversionService.convert(bank, BankResponseDto.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(bankResponse);
    }

    @GetMapping
    @ApiOperation(value = "Get all banks")
    public ResponseEntity<List<BankResponseDto>> getAllBanks() {
        var banks = bankService.getAllBanks().stream()
            .map(bank -> conversionService.convert(bank, BankResponseDto.class)).toList();

        return ResponseEntity.ok(banks);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get bank by id")
    public ResponseEntity<BankResponseDto> getBank(@PathVariable("id") Long id) {
        var bankResponse = conversionService.convert(bankService.getBank(id), BankResponseDto.class);

        return ResponseEntity.ok(bankResponse);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update bank by id")
    public ResponseEntity<BankResponseDto> updateBank(@PathVariable("id") Long id,
                                                      @Valid @RequestBody BankRequestDto bankRequestDto) {
        if (!id.equals(bankRequestDto.getId())) {
            throw new IdMismatchException(
                String.format("Id in path '%s' is not equal to id in body '%s'", id, bankRequestDto.getId()));
        }

        var bank = conversionService.convert(bankRequestDto, Bank.class);
        var bankResponse = conversionService.convert(bankService.updateBank(bank), BankResponseDto.class);

        return ResponseEntity.ok(bankResponse);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete bank by id")
    public ResponseEntity<Void> deleteBank(@PathVariable("id") Long id) {
        bankService.deleteBank(id);

        return ResponseEntity.noContent().build();
    }
}
