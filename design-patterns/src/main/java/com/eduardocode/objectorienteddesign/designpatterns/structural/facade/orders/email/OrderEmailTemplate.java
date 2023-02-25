package com.eduardocode.objectorienteddesign.designpatterns.structural.facade.orders.email;

public class OrderEmailTemplate extends Template {
    @Override
    public String format(Object obj) {
        return "ORDER EMAIL TEMPLATE";
    }
}
