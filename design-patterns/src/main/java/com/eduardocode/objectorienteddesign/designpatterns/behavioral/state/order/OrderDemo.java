package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.order;

public class OrderDemo {

    public static void main(String[] args) {
        OrderContext order = new OrderContext(100, 250.0);

        order.pay(200.0);
        order.getStatus();

        order.pay(250.0);
        order.getStatus();

        order.setAddressToDeliver("Address #1");
        order.deliver();

        order.getStatus();
    }
}
