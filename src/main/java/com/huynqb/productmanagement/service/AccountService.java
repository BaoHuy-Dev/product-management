package com.huynqb.productmanagement.service;

import com.huynqb.productmanagement.entity.Account;
import com.huynqb.productmanagement.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account login(String username, String password) {
        // Logic to authenticate user
        return accountRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }

    public Account findByUsername(String username) {
        // Logic to find account by username
        return accountRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }
}
