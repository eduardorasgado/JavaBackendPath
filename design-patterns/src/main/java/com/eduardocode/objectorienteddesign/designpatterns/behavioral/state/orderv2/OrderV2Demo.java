package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.orderv2;

public class OrderV2Demo {

    public static void main(String[] args) {
        Order order = new Order();
        order.process();
        order.process();
        order.process();

        System.out.println("-------Cancelling order------");
        order.cancel();
        //order.process();
        //order.cancel();
    }
}
