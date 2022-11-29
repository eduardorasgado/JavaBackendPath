package com.eduardorasgado.junit5application.examples.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void testPerson() {
        Account account = new Account("Andy", new BigDecimal("1000.1234"));

        String expected = "Andy";
        String actual = account.getPerson();

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void testBalance() {
        Account account = new Account("Andy", new BigDecimal("1000.1234"));

        assertNotNull(account.getBalance());
        assertEquals(1000.1234, account.getBalance().doubleValue(), "Expect balance");
        assertFalse(account.getBalance().compareTo(BigDecimal.ZERO) < 0);
    }

    @Test
    void testWithdraw() {
        Account account = new Account("Andy Ruiz", new BigDecimal("11250.45009"));
        account.withdraw(new BigDecimal(125.20));

        BigDecimal expected = new BigDecimal("11125.25008");
        BigDecimal actual = account.getBalance();

        assertEquals(expected, actual, "withdraw money from account");
    }

    @Test
    void testDeposit() {
        Account account = new Account("Andy Ruiz", new BigDecimal("11250.45009"));
        account.deposit(new BigDecimal(125.78));

        BigDecimal expected = new BigDecimal("11376.23009");
        BigDecimal actual = account.getBalance();

        assertEquals(expected, actual, "deposit money to account");
    }

    @Test
    void testReference() {
        Account account = new Account("John Doe", new BigDecimal("8900.9997"));
        Account account2 = new Account("John Doe", new BigDecimal("8900.9997"));

        assertEquals(account, account2, "Objects compared by value");
    }
}