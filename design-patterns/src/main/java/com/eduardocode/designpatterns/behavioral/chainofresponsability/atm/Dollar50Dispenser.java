package com.eduardocode.designpatterns.behavioral.chainofresponsability.atm;

public class Dollar50Dispenser implements ATMDispenser {
    private ATMDispenser next;

    @Override
    public void setNext(ATMDispenser next) {
        this.next = next;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount() >= 50) {
            int pieces = currency.getAmount() / 50;
            int remainder = currency.getAmount() % 50;

            System.out.println("Dispensing " + pieces + " $50 note");
            if(remainder > 0  && next != null) {
                next.dispense(new Currency(remainder));
            }
        }
        else {
            if( next != null) {
                next.dispense(currency);
            }
        }
    }

}
