package com.eduardocode.designpatterns.behavioral.state.order;

public class OrderCompleted implements OrderState {

    @Override
    public String getName() {
        return "Order Completed";
    }

    @Override
    public void updateState(OrderContext context) {
        System.out.println("Order completed");
    }
}
