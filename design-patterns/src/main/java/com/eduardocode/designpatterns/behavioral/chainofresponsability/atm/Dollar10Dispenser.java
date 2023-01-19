package com.eduardocode.designpatterns.behavioral.chainofresponsability.atm;

public class Dollar10Dispenser implements ATMDispenser {
    private ATMDispenser next;

    @Override
    public void setNext(ATMDispenser next) {
        this.next = next;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount() >= 10) {
            int pieces = currency.getAmount() / 10;
            int remainder = currency.getAmount() % 10;

            System.out.println("Dispensing " + pieces + " $10 note");
            if(remainder > 0 && next != null) {
                next.dispense(new Currency(remainder));
            }
        }
        else {
            System.out.println("Amount should be in multiple of 10s");
        }
    }
}
