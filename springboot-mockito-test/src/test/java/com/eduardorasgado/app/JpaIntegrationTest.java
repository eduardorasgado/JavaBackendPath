package com.eduardorasgado.app;

import com.eduardorasgado.app.models.Account;
import com.eduardorasgado.app.models.Bank;
import com.eduardorasgado.app.repositories.IAccountRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

// enabling every jpa features for testing
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JpaIntegrationTest {

    @Autowired
    IAccountRepository accountRepository;

    @Test
    @Order(1)
    void test_AccountRepository_When_FindByIdIsCalled() {
        Optional<Account> account = accountRepository.findById(1L);

        assertTrue(account.isPresent());
        assertEquals("Adam Smith", account.orElseThrow().getName());
    }

    @Test
    @Order(2)
    void test_AccountRepository_When_FindByNameIsCalled() {
        Optional<Account> optionalAccount = accountRepository.findByName(AccountTestData.getNewAccount001().orElseThrow().getName());

        assertTrue(optionalAccount.isPresent());

        Account account = optionalAccount.orElseThrow();
        assertEquals("Adam Smith", account.getName());
        assertEquals(0, account.getBalance().compareTo(new BigDecimal("1000")));
    }

    @Test
    @Order(4)
    void testAccountRepository_Should_ThrowNotEnoughMoneyException_When_FindByNameIsCalled() {
        Optional<Account> optionalAccount = accountRepository.findByName("Rod");

        assertThrows(NoSuchElementException.class, optionalAccount::orElseThrow);
        assertFalse(optionalAccount.isPresent());
    }

    @Test
    @Order(4)
    void testAccountRepository_Should_ReturnList_When_FindAllIsCalled() {
        List<Account> allAccounts = accountRepository.findAll();

        assertFalse(allAccounts.isEmpty());
        assertEquals(2, allAccounts.size());
    }

    @Test
    @Order(5)
    void testAccountRepository_Given_NewAccount_When_SaveAndFindByNameAreCalled_Then_AccountIsFoundAndHasCorrectData() {
        // given
        Account dummyAccount = new Account(null, "Andreas Ehn", new BigDecimal("3000"));

        // when
        accountRepository.save(dummyAccount);
        Optional<Account> optionalActualAccount = accountRepository.findByName(dummyAccount.getName());
        assertTrue(optionalActualAccount.isPresent());

        // then
        Account actualAccount = optionalActualAccount.orElseThrow();
        assertEquals("Andreas Ehn", actualAccount.getName());
        assertEquals(0, actualAccount.getBalance().compareTo(new BigDecimal("3000")));
        //assertEquals(3L, actualAccount.getId());
    }

    @Test
    @Order(6)
    void testAccountRepository_Given_NewAccount_When_SaveIsCalled_Then_AccountHasCorrectData() {
        // given
        Account dummyAccount = new Account(null, "Daniel Ek", new BigDecimal("5500"));

        // when
        Account actualAccount = accountRepository.save(dummyAccount);

        // then
        assertNotNull(actualAccount.getId());
        assertEquals("Daniel Ek", actualAccount.getName());
        assertEquals(0, actualAccount.getBalance().compareTo(new BigDecimal("5500")));
        //assertEquals(4L, actualAccount.getId());
    }

    @Test
    @Order(7)
    void testAccountRepository_Given_ExistingAccount_When_UpdateIsCalled_Then_SavedAccountHasUpdatedValues() {
        // given
        Account dummyAccount = new Account(null, "Daniel Ek", new BigDecimal("5500"));
        Account actualAccount = accountRepository.save(dummyAccount);
        Account savedAccount = actualAccount.clone();

        // when
        actualAccount.deposit(new BigDecimal("1000"));
        Account updatedAccount = accountRepository.save(actualAccount);

        // then
        assertNotSame(savedAccount, updatedAccount);
        assertNotNull(updatedAccount.getId());
        assertEquals("Daniel Ek", updatedAccount.getName());
        assertEquals(0, updatedAccount.getBalance().compareTo(new BigDecimal("6500")));
    }

    @Test
    @Order(8)
    void testAccountRepository_Given_ExistingAccount_When_DeleteIsCalled_Then_FindByIdReturnNullOptional() {
        Optional<Account> optionalAccount = accountRepository.findById(2L);
        assertTrue(optionalAccount.isPresent());

        Account account = optionalAccount.get();
        accountRepository.delete(account);

        optionalAccount = accountRepository.findByName(account.getName());
        assertThrows(NoSuchElementException.class, optionalAccount::orElseThrow);
    }
}
