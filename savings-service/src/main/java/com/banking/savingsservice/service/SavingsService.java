package com.banking.savingsservice.service;

import com.banking.savingsservice.entity.Savings;
import com.banking.savingsservice.repository.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingsService {


    @Autowired
    private SavingsRepository savingsRepository;


    public Savings saveSavings(Savings savings) {

        Double total = savings.getAmountDeposited() +
                (savings.getAmountDeposited() * (savings.getInterest() / 100) * savings.getYears());
        savings.setTotalValue(total.longValue());
        return savingsRepository.save(savings);
    }

    public List<Savings> getSavingsByAccountnumber(Long accountnumber) {
        return savingsRepository.findByAccountnumber(accountnumber);
    }
}