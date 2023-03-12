package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.orderv2;

public class InTransitOrder extends BaseState {

    public InTransitOrder(Order context) {
        super(context);
    }

    @Override
    public double handleCancellation() {
        super.handleCancellation();

        System.out.println("Contacting courier service for cancellation");
        System.out.println("Contacting payment gateway for transaction rollback");
        return 0;
    }

    @Override
    public void next() {
        System.out.println("Your in transit order has been delivered successfully. Order is closed.");
        setContextState(new DeliveredOrder(getContext()));
    }
}
