package com.eduardocode.objectorienteddesign.designpatterns.behavioral.observer.orders;

public class PriceObserver implements OrderObserver {

    @Override
    public void update(Order order) {
        double itemsCost = order.getItemCost();

        if ((itemsCost < 250)) {
            return;
        }

        if(itemsCost >= 500) {
            order.setDiscount(20);
        }
        else if(itemsCost >= 250) {
            order.setDiscount(10);
        }

        System.out.println("Updating order discount: " + order.getDiscount());
    }
}
