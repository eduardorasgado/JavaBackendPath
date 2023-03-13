package com.eduardocode.objectorienteddesign.designpatterns.behavioral.templatemethod.printer;

import java.io.File;
import java.io.FileNotFoundException;

public class PrinterDemo {

    private static OrderPrinter orderPrinter;

    public static void main(String[] args) throws FileNotFoundException {
        //orderPrinter = new TextPrinter();
        orderPrinter = new HtmlPrinter();

        Order order = new Order("asldkj");
        order.addItem("Keyboard", 100);
        order.addItem("motherboard", 1200);
        order.addItem("mouse", 20);
        order.addItem("headset", 940);

        String filename = ("src.main.java." + PrinterDemo.class.getPackageName() + ".order")
                .replace(".", File.separator) +  orderPrinter.getFileExtension();

        orderPrinter.printOrder(order, filename);

        System.out.println("Check the current package for the resulting file.");
    }
}
