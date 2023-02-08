package com.eduardocode.objectorienteddesign.designpatterns.structural.proxy.bank;

public class CapitalOne implements Bank {

    @Override
    public void withdraw(String account, int amount) {
        System.out.println("Withdrawing " + amount + " from " + account);
    }

    @Override
    public void deposit(String account, int amount) {
        System.out.println("Depositing " + amount + " to " + account);
    }
}
