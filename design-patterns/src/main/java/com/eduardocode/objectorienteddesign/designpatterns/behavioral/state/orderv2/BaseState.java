package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.orderv2;

public abstract class BaseState implements OrderState {
    private final Order context;

    public BaseState(Order context) {
        this.context = context;
        setContextState(this);
    }

    @Override
    public double handleCancellation() {
        setContextState(new CancelledOrder());
        return 0;
    }

    protected Order getContext() {
        return context;
    }

    protected void setContextState(OrderState orderState) {
        getContext().setCurrentState(orderState);
    }
}
