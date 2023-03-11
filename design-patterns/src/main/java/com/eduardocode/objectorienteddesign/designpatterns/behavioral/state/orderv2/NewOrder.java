package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.orderv2;

public class NewOrder extends BaseState {

    public NewOrder(Order context) {
        super(context);
    }

    @Override
    public double handleCancellation() {
        System.out.println("Cancelling a new order... No money transaction needs to be done");

        updateContextStateToCancelled();
        return 0;
    }
}
