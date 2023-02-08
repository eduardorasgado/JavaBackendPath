package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.order;

public class OrderProcessing implements OrderState {

    @Override
    public String getName() {
        return "Order processing";
    }

    @Override
    public void updateState(OrderContext context) {
        if(context.isPaid() && !context.getAddress().isBlank()) {
            context.setDelivered(true);
        }

        if(context.isDelivered()) {
            context.setCurrentState(new OrderCompleted());
        }
    }
}
