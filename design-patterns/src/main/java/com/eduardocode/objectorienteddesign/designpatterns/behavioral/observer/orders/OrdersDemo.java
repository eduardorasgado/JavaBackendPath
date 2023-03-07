package com.eduardocode.objectorienteddesign.designpatterns.behavioral.observer.orders;

public class OrdersDemo {

    public static void main(String[] args) {
        Order order = new Order("O1001");
        new PriceObserver(order);
        new QuantityObserver(order);

        addItemToOrder(order, 40);
        addItemToOrder(order, 100);
        addItemToOrder(order, 40);
        addItemToOrder(order, 50);
        addItemToOrder(order, 50);
        addItemToOrder(order, 100);
        addItemToOrder(order, 100);
        addItemToOrder(order, 60);
    }

    private static void addItemToOrder(Order order, int price) {
        order.addItem(price);
        System.out.println("adding " + price + " so item cost now is: " + order.getItemCost());
        System.out.println("total: " + order.getTotal());
    }
}
