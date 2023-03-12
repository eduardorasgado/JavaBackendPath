package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.orderv2;

public class Order {

    private OrderState currentState;

    public Order() {
        new NewOrder(this);
    }

    public double cancel() {
        return currentState.handleCancellation();
    }

    public void process() {
        try {
            currentState.next();
        } catch (UnsupportedOperationException exception) {
            System.out.println("LOGGER: " + exception.getMessage());
            throw new IllegalStateException();
        }
    }

    public void setCurrentState(OrderState currentState) {
        this.currentState = currentState;
    }
}
