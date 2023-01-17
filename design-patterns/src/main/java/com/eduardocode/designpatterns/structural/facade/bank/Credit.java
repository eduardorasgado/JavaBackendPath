package com.eduardocode.designpatterns.structural.facade.bank;

public class Credit {

    public boolean hasGoodCredit(Customer customer) {
        System.out.println("Check credit for " + customer.getName());
        return true;
    }
}
