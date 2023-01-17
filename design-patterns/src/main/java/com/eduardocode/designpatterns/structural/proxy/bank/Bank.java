package com.eduardocode.designpatterns.structural.proxy.bank;

public interface Bank {
    void withdraw(String account, int amount);

    void deposit(String account, int amount);
}
