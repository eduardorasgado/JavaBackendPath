package com.eduardocode.objectorienteddesign.designpatterns.behavioral.chainofresponsability.atmv2;

public class Dollar10Dispenser extends ATMDispenser {

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount() >= 10 && currency.getAmount() % 10 == 0) {
            int pieces = currency.getAmount() / 10;
            int remainder = currency.getAmount() % 10;

            System.out.println("Dispensing " + pieces + " $10 note");
            if(remainder > 0 && getNext() != null) {
                getNext().dispense(new Currency(remainder));
            }
        }
        else {
            System.out.println("Amount should be in multiple of 10s and greater than/equals to 10");
        }
    }
}
