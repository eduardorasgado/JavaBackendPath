package com.eduardorasgado.app.models;

import java.util.Objects;

public class Bank implements Cloneable{
    private Long id;
    private String name;
    private int totalTransfers;

    public Bank() {
    }

    public Bank(Long id, String name, int totalTransfers) {
        this.id = id;
        this.name = name;
        this.totalTransfers = totalTransfers;
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

    public int getTotalTransfers() {
        return totalTransfers;
    }

    public void setTotalTransfers(int totalTransfers) {
        this.totalTransfers = totalTransfers;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return getTotalTransfers() == bank.getTotalTransfers() && Objects.equals(getId(), bank.getId()) && Objects.equals(getName(), bank.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getTotalTransfers());
    }

    @Override
    public Bank clone() {
        return new Bank(getId(), getName(), getTotalTransfers());
    }
}
