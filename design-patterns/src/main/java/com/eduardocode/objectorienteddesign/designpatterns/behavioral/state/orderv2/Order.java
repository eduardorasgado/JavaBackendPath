package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.orderv2;

public class Order {

    private OrderState currentState;

    public Order() {
        currentState = new NewOrder();
    }

    public double cancel() {
        return currentState.handleCancellation();
    }

    public void paymentSuccessful() {
        currentState = new PaidOrder();
    }

    public void dispatched() {
        currentState = new InTransitOrder();
    }

    public void delivered() {
        currentState = new DeliveredOrder();
    }
}
