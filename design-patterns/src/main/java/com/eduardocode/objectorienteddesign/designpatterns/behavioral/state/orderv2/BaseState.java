package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.orderv2;

public abstract class BaseState implements OrderState {
    private final Order context;

    public BaseState(Order context) {
        this.context = context;
    }

    protected Order getContext() {
        return context;
    }

    protected void updateContextStateToCancelled() {
        getContext().setCurrentState(new CancelledOrder());
    }
}
