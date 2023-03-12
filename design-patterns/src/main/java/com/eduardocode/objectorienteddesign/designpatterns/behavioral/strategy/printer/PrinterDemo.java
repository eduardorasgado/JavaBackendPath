package com.eduardocode.objectorienteddesign.designpatterns.behavioral.strategy.printer;

import java.util.LinkedList;

public class PrinterDemo {

    private static LinkedList<Order> orders = new LinkedList<>();

    public static void main(String[] args) {
        createOrders();

        PrintService service = new PrintService();
        service.printOrders(orders);
    }

    private static void createOrders() {
        Order o = new Order("100");
        o.addItem("Soda", 2);
        o.addItem("Chips", 10);
        orders.add(o);

        o = new Order("200");
        o.addItem("Cake", 20);
        o.addItem("Cookies", 5);
        orders.add(o);

        o = new Order("300");
        o.addItem("Burger", 8);
        o.addItem("Fries", 5);
        orders.add(o);
    }


}
