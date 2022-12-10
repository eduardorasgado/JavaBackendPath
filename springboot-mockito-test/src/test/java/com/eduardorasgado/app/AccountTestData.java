package com.eduardorasgado.app;

import com.eduardorasgado.app.models.Account;
import com.eduardorasgado.app.models.Bank;

import java.math.BigDecimal;

public class AccountTestData {
    public static final Account ACCOUNT_001 = new Account(1L, "Adam Smith", new BigDecimal("1000"));

    public static final Account ACCOUNT_002 = new Account(2L, "John Finn", new BigDecimal("2000"));

    public static final Bank NU_BANK = new Bank(1L, "Nu Bank", 0);
}
