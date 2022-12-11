package com.eduardorasgado.app;

import com.eduardorasgado.app.models.Account;
import com.eduardorasgado.app.models.Bank;

import java.math.BigDecimal;

public class AccountTestData {
    private static final Account ACCOUNT_001 = new Account(1L, "Adam Smith", new BigDecimal("1000"));

    private static final Account ACCOUNT_002 = new Account(2L, "John Finn", new BigDecimal("2000"));

    private static final Bank NU_BANK = new Bank(1L, "Nu Bank", 0);

    public static Account getNewAccount001() {
        return ACCOUNT_001.clone();
    }

    public static Account getNewAccount002() {
        return ACCOUNT_002.clone();
    }

    public static Bank getNewBank() {
        return NU_BANK.clone();
    }
}
