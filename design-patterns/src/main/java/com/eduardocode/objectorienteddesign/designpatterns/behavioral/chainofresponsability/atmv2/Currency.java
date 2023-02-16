package com.eduardocode.objectorienteddesign.designpatterns.behavioral.chainofresponsability.atmv2;

public class Currency {
    private int amount;

    public Currency(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
