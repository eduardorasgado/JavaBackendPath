package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.orderv2;

public class CancelledOrder implements OrderState {

    @Override
    public double handleCancellation() throws UnsupportedOperationException {
        throw new IllegalStateException("Order has already been cancelled");
    }

    @Override
    public void next() {
        throw new UnsupportedOperationException("cannot call next in a cancelled order");
    }
}
