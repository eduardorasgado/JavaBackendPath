package com.eduardorasgado.junit5application.examples.models;

import com.eduardorasgado.junit5application.examples.exceptions.NotEnoughBalanceException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Account {
    private String person;
    private BigDecimal balance;

    public Account(String person, BigDecimal balance) {
        this.balance = balance;
        this.person = person;
    }

    public void withdraw(BigDecimal amount) {
        BigDecimal toWithdraw = getBalance().subtract(amount);

        if (toWithdraw.compareTo(BigDecimal.ZERO) < 0)
            throw new NotEnoughBalanceException("Not enough money to withdraw");

        setBalance(scaleAmount(toWithdraw));
    }

    public void deposit(BigDecimal amount) {
        setBalance(scaleAmount(getBalance().add(amount)));
    }

    private BigDecimal scaleAmount(BigDecimal amount) {
        return amount.setScale(5, RoundingMode.FLOOR);
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;
        return getPerson().equals(account.getPerson()) && getBalance().equals(account.getBalance());
    }
}
