package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.orderv2;

public class InTransitOrder extends BaseState {

    public InTransitOrder(Order context) {
        super(context);
    }

    @Override
    public double handleCancellation() {
        System.out.println("Contacting courier service for cancellation");
        System.out.println("Contacting payment gateway for transaction rollback");

        updateContextStateToCancelled();
        return 0;
    }
}
