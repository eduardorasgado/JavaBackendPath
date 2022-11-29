package com.eduardorasgado.junit5application.examples.models;

import com.eduardorasgado.junit5application.examples.exceptions.NotEnoughBalanceException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    void testNotEnoughBalanceToWithdraw() {
        Account account = new Account("Andy", new BigDecimal("1000.1234"));

        Exception exception = assertThrows(
                NotEnoughBalanceException.class,
                () -> account.withdraw(new BigDecimal(1200)),
                "Throwing exception when user does not have enough money to withdraw");

        String expected = "Not enough money to withdraw";
        String actual = exception.getMessage();

        assertEquals(expected, actual, "Message for not having enough money to withdraw is correct one");
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

    @Test
    void testTransferMoneyBetweenAccounts() {
        Account originAccount = new Account("John Doe", new BigDecimal("8900.50"));
        Account destinationAccount = new Account("Mark Twain", new BigDecimal("2560"));
        Bank bank = new Bank();
        bank.setName("Nu Bank");

        bank.transfer(originAccount, destinationAccount, new BigDecimal(500));

        assertTrue(originAccount.getBalance().compareTo(new BigDecimal("8400.50000")) == 0,
                "Origin account new balance after transferring money");
        assertTrue(destinationAccount.getBalance().compareTo(new BigDecimal(3060)) == 0,
                "Destination account new balance after receiving money");
    }

    @Test
    void testAddingBankAccounts() {
        List<Account> accounts = new ArrayList<>();
        Account originAccount = new Account("John Doe", new BigDecimal("8900.50"));
        Account destinationAccount = new Account("Mark Twain", new BigDecimal("2560"));
        Bank bank = new Bank();
        bank.setName("Nu Bank");

        bank.addAccount(originAccount);
        bank.addAccount(destinationAccount);

        assertEquals(2, bank.getAccountsCount(), "Accounts should be added to bank correctly");

        assertAll("Every Account's bank should not be null",
                () -> assertNotNull(originAccount.getBank()),
                () -> assertNotNull(destinationAccount.getBank()));

        assertAll("Every account's bank should match the bank they were added to",
                () -> assertEquals(bank.getName(), originAccount.getBank().getName()),
                () -> assertEquals(bank.getName(), destinationAccount.getBank().getName()));

        String expectedName = "Mark Twain";
        assertEquals(expectedName,
                bank.getAccounts().stream()
                        .filter(account -> account.getPerson().equals(expectedName))
                        .findFirst()
                        .orElseGet(() -> new Account("", BigDecimal.ZERO))
                        .getPerson(),
                "Certain person was added to bank account list"
                );
    }
}