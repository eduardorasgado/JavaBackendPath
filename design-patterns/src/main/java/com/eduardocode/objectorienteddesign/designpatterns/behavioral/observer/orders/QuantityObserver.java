package com.eduardocode.objectorienteddesign.designpatterns.behavioral.observer.orders;

public class QuantityObserver implements OrderObserver {

    public QuantityObserver(Order order) {
        order.attach(this);
    }

    @Override
    public void update(Order order) {
        int itemCount = order.getCount();

        if(itemCount <= 5) {
            order.setShippingCost(20);
        }
        else {
            order.setShippingCost(3 * itemCount);
        }

        System.out.println("updating order shipping cost: " + order.getShippingCost());
    }
}
