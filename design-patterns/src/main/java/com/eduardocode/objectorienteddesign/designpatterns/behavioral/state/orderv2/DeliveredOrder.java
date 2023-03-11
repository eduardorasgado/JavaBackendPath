package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.orderv2;

public class DeliveredOrder extends BaseState {

    public DeliveredOrder(Order context) {
        super(context);
    }

    @Override
    public double handleCancellation() {
        System.out.println("Contacting courier service for item pickup");
        System.out.println("Payment rollback will be initialized upon receiving returned item");

        updateContextStateToCancelled();
        return 0;
    }
}
