package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.orderv2;

public class PaidOrder extends BaseState {

    public PaidOrder(Order context) {
        super(context);
    }

    @Override
    public double handleCancellation() {
        super.handleCancellation();

        System.out.println("Contacting payment gateway to rollback transaction...");
        return 67.5;
    }

    @Override
    public void next() {
        System.out.println("Your paid order has been processed and it is in transit");
        setContextState(new InTransitOrder(getContext()));
    }
}
