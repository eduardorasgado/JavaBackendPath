package com.eduardocode.objectorienteddesign.designpatterns.behavioral.chainofresponsability.atmv2;

public class Dollar50Dispenser extends ATMDispenser {

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount() >= 50 && currency.getAmount() % 10 == 0) {
            int pieces = currency.getAmount() / 50;
            int remainder = currency.getAmount() % 50;

            System.out.println("Dispensing " + pieces + " $50 note");
            if(remainder > 0 && getNext() != null) {
                getNext().dispense(new Currency(remainder));
            }
        }
        else {
            if(getNext() != null) {
                getNext().dispense(currency);
            }
        }
    }
}
