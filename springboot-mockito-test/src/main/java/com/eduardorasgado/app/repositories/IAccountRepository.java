package com.eduardorasgado.app.repositories;

import com.eduardorasgado.app.models.Account;

import java.util.List;

public interface IAccountRepository {

    List<Account> findAll();

    Account findById(Long id);

    void update(Account account);
}
