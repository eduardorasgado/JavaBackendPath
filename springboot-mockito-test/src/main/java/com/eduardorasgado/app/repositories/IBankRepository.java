package com.eduardorasgado.app.repositories;

import com.eduardorasgado.app.models.Bank;

import java.util.List;

public interface IBankRepository {
    List<Bank> findAll();
    Bank findById(Long id);
    void update(Bank bank);
}
