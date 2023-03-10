package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.orderv2;

public class PaidOrder implements OrderState {
    @Override
    public double handleCancellation() {
        System.out.println("Contacting payment gateway to rollback transaction...");

        return 67.5;
    }
}
