package com.banking.savingsservice.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

    public List<AccountDto> accountDetails;
    public List<SavingsDto> savingsDetails;

    public List<AccountDto> getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(List<AccountDto> accountDetails) {
        this.accountDetails = accountDetails;
    }

    public List<SavingsDto> getSavingsDetails() {
        return savingsDetails;
    }

    public void setSavingsDetails(List<SavingsDto> savingsDetails) {
        this.savingsDetails = savingsDetails;
    }
}