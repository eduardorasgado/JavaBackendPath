package com.eduardorasgado.junit5application.examples.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;

    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void transfer(Account originAccount, Account destinationAccount, BigDecimal amount) {
        originAccount.withdraw(amount);
        destinationAccount.deposit(amount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        account.setBank(this);
    }

    public int getAccountsCount() {
        return getAccounts().size();
    }
}
