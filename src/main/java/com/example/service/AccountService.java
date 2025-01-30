package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    /*Added method to get all accounts */
    public List<Account> getAllAccounts (){
        return accountRepository.findAll();
    }

    /*Method to verify a user to login */
    public Account verifyAccount(Account account) throws ResponseStatusException{
        Optional<Account> accountOptional = accountRepository.findByUsernameAndPassword(account.getUsername(), account.getPassword());
        if (accountOptional.isPresent()){
            return accountOptional.get();
        }
        else{
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }


}
