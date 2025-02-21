package com.banking.savingsservice.repository;


import com.banking.savingsservice.entity.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavingsRepository extends JpaRepository<Savings,Long> {
    List<Savings> findByAccountnumber(Long accountnumber);
}