package com.banking.accountservice.repository;

import com.banking.accountservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {

    List<Account> findByAccountnumber(String accountnumber);
}
