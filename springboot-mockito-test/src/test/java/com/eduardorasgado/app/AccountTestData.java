package com.eduardorasgado.app;

import com.eduardorasgado.app.models.Account;
import com.eduardorasgado.app.models.Bank;

import java.math.BigDecimal;
import java.util.Optional;

public class AccountTestData {
    private static final Account ACCOUNT_001 = new Account(1L, "Adam Smith", new BigDecimal("1000"));

    private static final Account ACCOUNT_002 = new Account(2L, "John Finn", new BigDecimal("2000"));

    private static final Bank NU_BANK = new Bank(1L, "Nu Bank", 0);

    public static Optional<Account> getNewAccount001() {
        return Optional.of(ACCOUNT_001.clone());
    }

    public static Optional<Account> getNewAccount002() {
        return Optional.of(ACCOUNT_002.clone());
    }

    public static Optional<Bank> getNewBank() {
        return Optional.of(NU_BANK.clone());
    }

    public static final Account dummyAccount1 = new Account(null, "Gary Lorenz", new BigDecimal("2700"));
    public static final Account dummyAccount2 = new Account(null, "Michael Sanchez", new BigDecimal("12500"));

}
