package com.eduardorasgado.app.models;

import com.eduardorasgado.app.exceptions.NotEnoughMoneyException;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "accounts")
public class Account implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal balance;

    public Account() {
    }

    public Account(Long id, String name, BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public void withdraw(BigDecimal amount){
        BigDecimal newBalance = getBalance().subtract(amount);
        if(newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new NotEnoughMoneyException("Not enough money to withdraw");
        }
        setBalance(newBalance);
    }

    public void deposit(BigDecimal amount) {
        setBalance(getBalance().add(amount));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(getId(), account.getId()) && Objects.equals(getName(), account.getName()) && Objects.equals(getBalance(), account.getBalance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBalance());
    }

    @Override
    public Account clone() {
        return new Account(getId(), getName(), getBalance());
    }
}
