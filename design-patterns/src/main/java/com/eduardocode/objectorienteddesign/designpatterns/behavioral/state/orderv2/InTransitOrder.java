package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.orderv2;

public class InTransitOrder implements OrderState {
    @Override
    public double handleCancellation() {
        System.out.println("Contacting courier service for cancellation");
        System.out.println("Contacting payment gateway for transaction rollback");

        return 0;
    }
}
