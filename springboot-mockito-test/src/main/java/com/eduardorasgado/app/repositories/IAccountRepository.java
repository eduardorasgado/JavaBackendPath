package com.eduardorasgado.app.repositories;

import com.eduardorasgado.app.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IAccountRepository extends JpaRepository<Account, Long> {
    // hibernate query language
    @Query("select a from Account a where a.name = ?1")
    Optional<Account> findByName(String name);
}
