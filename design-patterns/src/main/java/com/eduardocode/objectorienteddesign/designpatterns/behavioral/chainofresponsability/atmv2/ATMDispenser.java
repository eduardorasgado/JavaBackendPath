package com.eduardocode.objectorienteddesign.designpatterns.behavioral.chainofresponsability.atmv2;

public abstract class ATMDispenser {
    private ATMDispenser next;

    public ATMDispenser() {
    }

    public ATMDispenser(ATMDispenser next) {
        this.next = next;
    }

    public void setNext(ATMDispenser next) {
        this.next = next;
    }

    public ATMDispenser getNext() {
        return next;
    }

    public abstract void dispense(Currency currency);
}
