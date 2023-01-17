package com.eduardocode.designpatterns.structural.facade.bank;

public class Mortgage {
    private Bank bank = new Bank();
    private Loan loan = new Loan();
    private Credit credit = new Credit();

    public boolean isEligible(Customer customer, int amount) {
        System.out.println("Mortgage check for " + customer.getName());

        if(!bank.hasSufficientSavings(customer, amount) || !loan.hasNoBadLoans(customer) || !credit.hasGoodCredit(customer)) {
            return false;
        }
        return true;
    }
}
