package com.eduardorasgado.app.services;

import com.eduardorasgado.app.models.Account;

import java.math.BigDecimal;

public interface IAccountService {
    Account findById(Long id);
    int getTotalTransfersByBankId(Long bankId);

    BigDecimal getBalanceById(Long id);

    void transfer(Long originAccountId, Long destinationAccountId, Long bankId, BigDecimal amount);
}
