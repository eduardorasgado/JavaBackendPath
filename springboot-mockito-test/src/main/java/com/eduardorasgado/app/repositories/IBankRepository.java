package com.eduardorasgado.app.repositories;

import com.eduardorasgado.app.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBankRepository extends JpaRepository<Bank, Long> {
}
