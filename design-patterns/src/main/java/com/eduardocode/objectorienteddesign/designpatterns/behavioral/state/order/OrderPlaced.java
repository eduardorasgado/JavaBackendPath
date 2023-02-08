package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.order;

public class OrderPlaced implements OrderState {


    @Override
    public String getName() {
        return "Order Placed";
    }

    @Override
    public void updateState(OrderContext context) {
        if(context.isPaid()) {
            OrderState newState = new OrderProcessing();
            System.out.println("Order paid, changing state to " + newState.getName());
            context.setCurrentState(newState);
        }
    }
}
