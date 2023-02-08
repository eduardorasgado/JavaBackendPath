package com.eduardocode.objectorienteddesign.designpatterns.behavioral.chainofresponsability.atm;

public class AtmDemo {

    public static void main(String[] args) {
        ATMDispenser c1 = new Dollar50Dispenser();
        ATMDispenser c2 = new Dollar20Dispenser();
        ATMDispenser c3 = new Dollar10Dispenser();

        c1.setNext(c2);
        c2.setNext(c3);

        c1.dispense(new Currency(80));
        System.out.println();
        c1.dispense(new Currency(50));
        System.out.println();
        c1.dispense(new Currency(30));

        System.out.println();
        c1.dispense(new Currency(15));

        System.out.println();
        c1.dispense(new Currency(5));

        System.out.println();
        c1.dispense(new Currency(55));
    }
}
