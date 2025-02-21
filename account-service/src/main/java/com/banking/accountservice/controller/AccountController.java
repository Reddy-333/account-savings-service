package com.banking.accountservice.controller;

import com.banking.accountservice.entity.Account;
import com.banking.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService service;

    @PostMapping
    public Account create(@RequestBody Account account) {
        return service.create(account);
    }

    @GetMapping("/{accountnumber}")
    public List<Account> getAccount(@PathVariable String accountnumber) {
        return service.getAccount(accountnumber);
    }


}