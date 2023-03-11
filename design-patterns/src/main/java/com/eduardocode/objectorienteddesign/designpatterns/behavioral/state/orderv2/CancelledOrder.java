package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.orderv2;

public class CancelledOrder implements OrderState {

    @Override
    public double handleCancellation() {
        throw new IllegalStateException("Order has already been cancelled");
    }
}
