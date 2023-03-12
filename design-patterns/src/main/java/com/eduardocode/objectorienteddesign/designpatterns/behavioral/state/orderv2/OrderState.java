package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.orderv2;

public interface OrderState {

    double handleCancellation() throws UnsupportedOperationException;

    void next() throws UnsupportedOperationException;
}
