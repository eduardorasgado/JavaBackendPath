package com.eduardocode.objectorienteddesign.designpatterns.behavioral.chainofresponsability.atmv2;

import java.util.Scanner;

public class AtmDemo {

    private final ATMDispenser atmDispenser;

    public AtmDemo() {
        ATMDispenser c1 = new Dollar50Dispenser();
        ATMDispenser c2 = new Dollar20Dispenser();
        ATMDispenser c3 = new Dollar10Dispenser();

        c1.setNext(c2);
        c2.setNext(c3);

        atmDispenser = c1;
    }
    public static void main(String[] args) {
        AtmDemo app = new AtmDemo();
        int amount = 0;
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Enter amount to dispense: ");
            app.atmDispenser.dispense(new Currency(scanner.nextInt()));
        }
    }
}
