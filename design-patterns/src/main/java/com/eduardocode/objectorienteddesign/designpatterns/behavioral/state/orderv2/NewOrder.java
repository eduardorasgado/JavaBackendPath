package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.orderv2;

public class NewOrder extends BaseState {

    public NewOrder(Order context) {
        super(context);
        System.out.println("A new order has been created");
    }

    @Override
    public double handleCancellation() {
        super.handleCancellation();

        System.out.println("Cancelling a new order... No money transaction needs to be done");
        return 0;
    }

    @Override
    public void next() {
        System.out.println("your new order payment has been processed.");
        setContextState(new PaidOrder(getContext()));
    }
}
