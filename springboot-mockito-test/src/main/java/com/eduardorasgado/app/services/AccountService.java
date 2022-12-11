package com.eduardorasgado.app.services;

import com.eduardorasgado.app.exceptions.NotEnoughMoneyException;
import com.eduardorasgado.app.models.Account;
import com.eduardorasgado.app.models.Bank;
import com.eduardorasgado.app.repositories.IAccountRepository;
import com.eduardorasgado.app.repositories.IBankRepository;

import java.math.BigDecimal;

public class AccountService implements IAccountService {

    private IAccountRepository accountRepository;

    private IBankRepository bankRepository;

    public AccountService(IAccountRepository accountRepository, IBankRepository bankRepository) {
        this.accountRepository = accountRepository;
        this.bankRepository = bankRepository;
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public int getTotalTransfersByBankId(Long bankId) {
        Bank bank = bankRepository.findById(bankId);

        return bank.getTotalTransfers();
    }

    @Override
    public BigDecimal getBalanceById(Long id) {
        Account account = accountRepository.findById(id);

        return account.getBalance();
    }

    @Override
    public void transfer(Long originAccountId, Long destinationAccountId, Long bankId, BigDecimal amount) {
        Account originAccount = accountRepository.findById(originAccountId);
        Account destinationAccount = accountRepository.findById(destinationAccountId);
        Bank bank = bankRepository.findById(bankId);

        try {
            originAccount.withdraw(amount);
            accountRepository.update(originAccount);

            destinationAccount.deposit(amount);
            accountRepository.update(destinationAccount);

            int totalTransfered = bank.getTotalTransfers();
            bank.setTotalTransfers(++totalTransfered);
            bankRepository.update(bank);
        } catch (NotEnoughMoneyException ex) {
            System.out.println("Could not perform the money transfer, error: " + ex.getMessage());
            throw ex;
        }
    }
}
