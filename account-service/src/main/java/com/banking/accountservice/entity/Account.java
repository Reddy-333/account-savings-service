package com.banking.accountservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class Account {
    @Id
    private Long id;
    private String name;
    private String accountnumber;
    private String branch;
    private String ifscCode;
    private String balance;
    private String bankName = "Default Bank";
}
