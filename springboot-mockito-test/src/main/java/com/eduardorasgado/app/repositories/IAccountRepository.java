package com.eduardorasgado.app.repositories;

import com.eduardorasgado.app.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Long> {
}
