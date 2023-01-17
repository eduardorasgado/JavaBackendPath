package com.eduardocode.designpatterns.structural.facade.bank;

public class Bank {

    public boolean hasSufficientSavings(Customer customer, int amount) {
        System.out.println("Check bank for " + customer.getName());
        return true;
    }
}
