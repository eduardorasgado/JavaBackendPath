package com.eduardocode.objectorienteddesign.designpatterns.behavioral.chainofresponsability.atm;

public class Currency {
    private int amount;

    public Currency(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
