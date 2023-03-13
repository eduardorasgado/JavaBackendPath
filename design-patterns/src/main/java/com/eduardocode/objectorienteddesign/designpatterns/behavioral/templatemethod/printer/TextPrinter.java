package com.eduardocode.objectorienteddesign.designpatterns.behavioral.templatemethod.printer;

import java.util.Map;
import java.util.stream.Collectors;

public class TextPrinter extends OrderPrinter {

    @Override
    protected String start() {
        return "---- Order Details ----";
    }

    @Override
    protected String formatOrderNumber(Order order) {
        return "Order #" + order.getId();
    }

    @Override
    protected String formatItems(Order order) {
        return "Items \n------------------\n"
                + order.getItemsAsSet().stream()
                    .map(entry -> entry.getKey() + " $" + entry.getValue())
                    .collect(Collectors.joining("\n"))
                + "\n------------------";
    }

    @Override
    protected String formatTotal(Order order) {
        return "Total: $" + order.getTotal();
    }

    @Override
    protected String end() {
        return "";
    }

    @Override
    public String getFileExtension() {
        return ".txt";
    }
}
