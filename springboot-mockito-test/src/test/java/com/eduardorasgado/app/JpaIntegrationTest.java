package com.eduardorasgado.app;

import com.eduardorasgado.app.models.Account;
import com.eduardorasgado.app.repositories.IAccountRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
