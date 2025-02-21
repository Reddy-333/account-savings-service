package com.banking.savingsservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Savings {

    @Id
    public Long id;
    public Long accountnumber;
    public String savingType;
    public Long amountDeposited;
    public Integer years;
    public Double interest;
    public Long totalValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(Long accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getSavingType() {
        return savingType;
    }

    public void setSavingType(String savingType) {
        this.savingType = savingType;
    }

    public Long getAmountDeposited() {
        return amountDeposited;
    }

    public void setAmountDeposited(Long amountDeposited) {
        this.amountDeposited = amountDeposited;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Long getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Long totalValue) {
        this.totalValue = totalValue;
    }
}