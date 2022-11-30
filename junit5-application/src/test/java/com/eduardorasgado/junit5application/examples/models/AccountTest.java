package com.eduardorasgado.junit5application.examples.models;

import com.eduardorasgado.junit5application.examples.exceptions.NotEnoughBalanceException;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// This annotation is the default so it is not required, but it is here for showing that
// it is also possible to have a per class LifeCycle(not recommended for unit testing)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class AccountTest {

    Account account;

    @BeforeAll
    static void initAccountClassTest() {
        System.out.println("---------Initializing ACCOUNT test suite---------");
    }

    @AfterAll
    static void exitAccountClassTest() {
        System.out.println("---------Exiting ACCOUNT test suite--------------");
    }
    @BeforeEach
    void initAccountMethodTest() {
        System.out.println("--------starting unit test-------");
        account = new Account("Andy", new BigDecimal("1000.1234"));
    }

    @AfterEach
    void exitAccountMethodTest() {
        System.out.println("--------leaving unit test------");
    }

    @Test
    @DisplayName("Account person name test")
    void testPerson() {
        String expected = "Andy";
        String actual = account.getPerson();

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Account Balance Testing")
    void testBalance() {
        assertNotNull(account.getBalance());
        assertEquals(1000.1234, account.getBalance().doubleValue(), "Expect balance");
        assertFalse(account.getBalance().compareTo(BigDecimal.ZERO) < 0);
    }

    @Test
    @DisplayName("User withdraws money from account")
    void testWithdraw() {
        account = new Account("Andy Ruiz", new BigDecimal("11250.45009"));
        account.withdraw(new BigDecimal(125.20));

        BigDecimal expected = new BigDecimal("11125.25008");
        BigDecimal actual = account.getBalance();

        assertEquals(expected, actual, () -> "withdraw money from account");
    }

    @Test
    @DisplayName("User withdraws but not enough money into account")
    void testNotEnoughBalanceToWithdraw() {
        Exception exception = assertThrows(
                NotEnoughBalanceException.class,
                () -> account.withdraw(new BigDecimal(1200)),
                () -> "Throwing exception when user does not have enough money to withdraw");

        String expected = "Not enough money to withdraw";
        String actual = exception.getMessage();

        assertEquals(expected, actual, () -> "Message for not having enough money to withdraw is correct one");
    }

    @Test
    @DisplayName("User deposits money into account")
    void testDeposit() {
        account = new Account("Andy Ruiz", new BigDecimal("11250.45009"));
        account.deposit(new BigDecimal(125.78));

        BigDecimal expected = new BigDecimal("11376.23009");
        BigDecimal actual = account.getBalance();

        assertEquals(expected, actual, () -> "deposit money to account");
    }

    @Test
    @DisplayName("Comparing accounts with same data test")
    void testComparingTwoAccountsWithSameData() {
        account = new Account("John Doe", new BigDecimal("8900.9997"));
        Account account2 = new Account("John Doe", new BigDecimal("8900.9997"));

        assertEquals(account, account2, () -> "Objects compared by value");
    }

    @Test
    @DisplayName("Triggering test failure")
    @Disabled
    void testToBeDisabled() {
        fail();
    }

    @Test
    @DisplayName("Transferring money from one account to another account")
    void testTransferMoneyBetweenAccounts() {
        Account originAccount = new Account("John Doe", new BigDecimal("8900.50"));
        Account destinationAccount = new Account("Mark Twain", new BigDecimal("2560"));
        Bank bank = new Bank();
        bank.setName("Nu Bank");

        bank.transfer(originAccount, destinationAccount, new BigDecimal(500));

        assertTrue(originAccount.getBalance().compareTo(new BigDecimal("8400.50000")) == 0,
                () -> "Origin account new balance after transferring money");
        assertTrue(destinationAccount.getBalance().compareTo(new BigDecimal(3060)) == 0,
                () -> "Destination account new balance after receiving money");
    }

    @Test
    @DisplayName("Adding multiple accounts to a bank")
    void testAddingBankAccounts() {
        List<Account> accounts = new ArrayList<>();
        Account originAccount = new Account("John Doe", new BigDecimal("8900.50"));
        Account destinationAccount = new Account("Mark Twain", new BigDecimal("2560"));
        Bank bank = new Bank();
        bank.setName("Nu Bank");

        bank.addAccount(originAccount);
        bank.addAccount(destinationAccount);

        assertAll(
                () -> assertEquals(2, bank.getAccountsCount(), () -> "Accounts should be added to bank correctly"),
                () -> {
                    assertAll("Every Account's bank should not be null",
                            () -> assertNotNull(originAccount.getBank()),
                            () -> assertNotNull(destinationAccount.getBank()));
                },
                () -> {
                    assertAll("Every account's bank should match the bank they were added to",
                            () -> assertEquals(bank.getName(), originAccount.getBank().getName()),
                            () -> assertEquals(bank.getName(), destinationAccount.getBank().getName()));
                },
                () -> {
                    String expectedName = "Mark Twain";
                    assertEquals(expectedName,
                            bank.getAccounts().stream()
                                    .filter(account -> account.getPerson().equals(expectedName))
                                    .findFirst()
                                    .orElseGet(() -> new Account("", BigDecimal.ZERO))
                                    .getPerson(),
                            () -> "Certain person was added to bank account list"
                    );
                }
        );
    }
}