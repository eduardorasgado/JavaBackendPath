package com.eduardocode.objectorienteddesign.designpatterns.behavioral.templatemethod.printer;

import java.util.stream.Collectors;

public class HtmlPrinter extends OrderPrinter {
    @Override
    protected String start() {
        return "<html>\n<head><title>Order Details</title></head>\n<body>";
    }

    @Override
    protected String formatOrderNumber(Order order) {
        return "<h1>Order #"+order.getId()+"</h1>";
    }

    @Override
    protected String formatItems(Order order) {
        return "<p><ul>"
                + order.getItemsAsSet().stream()
                    .map(entry -> "\n\t<li>" + entry.getKey() + " $" + entry.getValue() + "</li>")
                    .collect(Collectors.joining())
                + "\n</ul></p>";
    }

    @Override
    protected String formatTotal(Order order) {
        return "<br/><hr/><h3>Total : $"+order.getTotal()+"</h3>";
    }

    @Override
    protected String end() {
        return "</body>\n</html>";
    }

    @Override
    public String getFileExtension() {
        return ".html";
    }
}
