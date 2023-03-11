package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.orderv2;

public class Order {

    private OrderState currentState;

    public Order() {
        setCurrentState(new NewOrder(this));
    }

    public double cancel() {
        return currentState.handleCancellation();
    }

    public void paymentSuccessful() {
        setCurrentState(new PaidOrder(this));
    }

    public void dispatched() {
        setCurrentState(new InTransitOrder(this));
    }

    public void delivered() {
        setCurrentState(new DeliveredOrder(this));
    }

    public void setCurrentState(OrderState currentState) {
        this.currentState = currentState;
    }
}
