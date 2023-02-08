package com.eduardocode.objectorienteddesign.designpatterns.structural.facade.bank;

public class Loan {
    public boolean hasNoBadLoans(Customer customer) {
        System.out.println("Check loans for " + customer.getName());
        return true;
    }
}
