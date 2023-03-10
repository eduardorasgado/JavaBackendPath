package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.orderv2;

public class NewOrder implements OrderState {
    @Override
    public double handleCancellation() {
        System.out.println("Cancelling a new order... No money transaction needs to be done");
        return 0;
    }
}
