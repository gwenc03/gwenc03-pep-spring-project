package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

@Service
public class AccountService {
    private AccountRepository accountRepository;
    @Autowired
    public AccountService (AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    /*Method to Register a new user */
    public Account registerAccount (Account newAccount){
        return accountRepository.save(newAccount);
    }

    /*Method to verify a user to login */
    // public Account verifyAccount(Account account){
    //     Optional<Account> accountOptional = accountRepository.findById(account.getAccountId());
    //     if (accountOptional.isPresent()){

    //     }
    // }


}
