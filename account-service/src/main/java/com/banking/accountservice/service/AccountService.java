package com.banking.accountservice.service;

import com.banking.accountservice.entity.Account;
import com.banking.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository repo;

    public Account create(Account account) {
        return repo.save(account);
    }

    public List<Account> getAccount(String accountnumber) {
        return repo.findByAccountnumber(accountnumber);
    }


}
