package com.eduardocode.designpatterns.structural.facade.bank;

public class BankDemo {

    public static void main(String[] args) {
        Mortgage mortgage = new Mortgage();
        Customer customer = new Customer("Joe Smith");

        boolean eligible = mortgage.isEligible(customer, 125000);

        System.out.println(customer.getName() + " has been " + (eligible ? "Approved" : "Rejected"));
    }
}
