package com.eduardocode.objectorienteddesign.designpatterns.behavioral.chainofresponsability.atm;

public interface ATMDispenser {
    void setNext(ATMDispenser next);

    void dispense(Currency currency);
}
