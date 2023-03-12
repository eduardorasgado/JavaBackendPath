package com.eduardocode.objectorienteddesign.designpatterns.behavioral.strategy.printer;

import java.util.Collection;
import java.util.LinkedList;

public class PrintService {

    private OrderPrinter printer;

    public PrintService(OrderPrinter printer) {
        this.printer = printer;
    }

    public void printOrders(LinkedList<Order> orders) {
        printer.print(orders);
    }
}
