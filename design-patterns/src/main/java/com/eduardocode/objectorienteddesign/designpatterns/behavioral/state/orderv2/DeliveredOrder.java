package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.orderv2;

public class DeliveredOrder extends BaseState {

    public DeliveredOrder(Order context) {
        super(context);
    }

    @Override
    public double handleCancellation() {
        super.handleCancellation();

        System.out.println("Contacting courier service for item pickup");
        System.out.println("Payment rollback will be initialized upon receiving returned item");
        return 0;
    }

    @Override
    public void next() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("The order has already been delivered and the order is closed.");
    }
}
