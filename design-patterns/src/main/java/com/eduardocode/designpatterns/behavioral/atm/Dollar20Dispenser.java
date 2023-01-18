package com.eduardocode.designpatterns.behavioral.atm;

public class Dollar20Dispenser implements ATMDispenser {
    private ATMDispenser next;

    @Override
    public void setNext(ATMDispenser next) {
        this.next = next;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount() >= 20) {
            int pieces = currency.getAmount() / 20;
            int remainder = currency.getAmount() % 20;

            System.out.println("Dispensing " + pieces + " $20 note");
            if(remainder > 0 && next != null) {
                next.dispense(new Currency(remainder));
            }
        }
        else {
            if(next != null) {
                next.dispense(currency);
            }

        }
    }
}
