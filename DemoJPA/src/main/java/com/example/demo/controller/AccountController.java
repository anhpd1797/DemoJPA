package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllAccount() {
        Map<String, Object> response = new HashMap<>();
        try{
            List<Account> accountList = accountService.findAllAccount();
            response.put("studentList", accountList);
        } catch (Exception ex){
            System.out.println(ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        try {
            Account accountReturn = accountService.save(account);
            if (accountReturn == null) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
        } catch (Exception ex){
            System.out.println(ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
