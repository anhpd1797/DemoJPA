package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repos.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account save(Account account) {
        try {
            return accountRepository.save(account);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Account> findAllAccount() {
        try {
            return accountRepository.findAll();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
}
