package com.eduardocode.designpatterns.behavioral.atm;

public interface ATMDispenser {
    void setNext(ATMDispenser next);

    void dispense(Currency currency);
}
