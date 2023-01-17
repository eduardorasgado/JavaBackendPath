package com.eduardocode.designpatterns.structural.proxy.bank;

public class BankDemo {

    public static void main(String[] args) {
        Bank bank = new BankProxy("root", "admin");

        bank.withdraw("12345", 50);
        bank.deposit("12345", 100);

        bank = new BankProxy("user", "pass");

        bank.withdraw("10005", 520);
        bank.deposit("10005", 1010);
    }
}
