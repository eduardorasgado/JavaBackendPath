package com.eduardocode.objectorienteddesign.designpatterns.behavioral.command.bankaccount;

public class BankAccount {
    private int balance;
    private final int overdraftLimit = -500;


    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited " + amount + ", balance = " + balance);
    }

    public boolean withdraw(int amount) {
        if(balance - amount >= overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ", balance = " + balance);

            return true;
        } else {
            System.out.println("Insufficient funds");

            return false;
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                '}';
    }
}
