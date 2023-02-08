package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.order;

public interface OrderState {

    String getName();

    void updateState(OrderContext context);
}
