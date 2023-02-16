package com.eduardocode.objectorienteddesign.designpatterns.behavioral.chainofresponsability.atmv2;

public class Dollar20Dispenser extends ATMDispenser {

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount() >= 20 && currency.getAmount() % 10 == 0) {
            int pieces = currency.getAmount() / 20;
            int remainder = currency.getAmount() % 20;

            System.out.println("Dispensing " + pieces + " $20 note");
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
