package com.example.demo.repos;

import com.example.demo.model.Account;
import com.example.demo.model.Student;

import java.util.List;

public interface AccountRepository extends BaseRepository<Account>{
    @Override
    List<Account> findAll();

    @Override
    Account save(Account account);
}
