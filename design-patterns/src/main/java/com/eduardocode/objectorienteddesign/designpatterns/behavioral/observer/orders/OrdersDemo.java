package com.eduardocode.objectorienteddesign.designpatterns.behavioral.observer.orders;

public class OrdersDemo {

    public static void main(String[] args) {
        Order order = new Order("O1001");
        order.attach(new PriceObserver());
        order.attach(new QuantityObserver());

        addingItemToOrder(order, 40);
        addingItemToOrder(order, 100);
        addingItemToOrder(order, 40);
        addingItemToOrder(order, 50);
        addingItemToOrder(order, 50);
        addingItemToOrder(order, 100);
        addingItemToOrder(order, 100);
        addingItemToOrder(order, 60);
    }

    private static void addingItemToOrder(Order order, int price) {
        order.addItem(price);
        System.out.println("adding " + price + " so item cost now is: " + order.getItemCost());
        System.out.println("total: " + order.getTotal());
    }
}
