package com.banking.savingsservice.controller;

import com.banking.savingsservice.dto.AccountDto;
import com.banking.savingsservice.dto.ResponseDto;
import com.banking.savingsservice.dto.SavingsDto;
import com.banking.savingsservice.entity.Savings;
import com.banking.savingsservice.service.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/savings")
public class SavingsController {

    @Autowired
    SavingsService savingsService;

    @Autowired
    WebClient.Builder webClientBuilder;

    // POST Endpoint
    @PostMapping
    public Savings createSavings(@RequestBody Savings savings) {
        return savingsService.saveSavings(savings);
    }

    // GET Endpoint
    @GetMapping("/{accountnumber}")
    public Mono<ResponseDto> getSavingsDetails(@PathVariable Long accountnumber) {
        // Fetch list of accounts

        Mono<List<AccountDto>> accountDetails = webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/accounts/" + accountnumber)
                .retrieve()
                .bodyToFlux(AccountDto.class)
                .collectList();

        // Fetch savings details
        Mono<List<SavingsDto>> savingsDetails = Mono.fromSupplier(() ->
                savingsService.getSavingsByAccountnumber(accountnumber).stream().map(saving ->
                        new SavingsDto(
                                saving.getId(),
                                saving.getAccountnumber(),
                                saving.getSavingType(),
                                saving.getAmountDeposited(),
                                saving.getYears(),
                                saving.getInterest(),
                                saving.getTotalValue()
                        )
                ).toList()
        );


        return Mono.zip(accountDetails, savingsDetails, (accounts, savings) -> new ResponseDto(accounts, savings));
    }
}

