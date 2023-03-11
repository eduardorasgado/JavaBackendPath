package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.orderv2;

public class OrderV2Demo {

    public static void main(String[] args) {
        Order order = new Order();
        order.paymentSuccessful();
        order.dispatched();
        order.delivered();

        order.cancel();
        //order.cancel();
    }
}
