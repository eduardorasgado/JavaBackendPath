package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.orderv2;

public class PaidOrder extends BaseState {

    public PaidOrder(Order context) {
        super(context);
    }

    @Override
    public double handleCancellation() {
        System.out.println("Contacting payment gateway to rollback transaction...");

        updateContextStateToCancelled();
        return 67.5;
    }
}
