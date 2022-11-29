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

        assertEquals(expected, actual);
    }

    @Test
    void testBalance() {
        Account account = new Account("Andy", new BigDecimal("1000.1234"));

        assertEquals(1000.1234, account.getBalance().doubleValue(), "Expect balance");
        assertFalse(account.getBalance().compareTo(BigDecimal.ZERO) < 0);
    }

    @Test
    void testReference() {
        Account account = new Account("John Doe", new BigDecimal("8900.9997"));
        Account account2 = new Account("John Doe", new BigDecimal("8900.9997"));

        assertNotEquals(account, account2, "Different objects");
    }
}