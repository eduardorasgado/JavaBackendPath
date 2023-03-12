package com.eduardocode.objectorienteddesign.designpatterns.behavioral.strategy.printer;

import java.util.Collection;

public interface OrderPrinter {
    void print(Collection<Order> orders);
}
