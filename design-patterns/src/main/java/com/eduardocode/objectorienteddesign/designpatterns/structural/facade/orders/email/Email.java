package com.eduardocode.objectorienteddesign.designpatterns.structural.facade.orders.email;

public class Email {
    public static EmailBuilder getBuilder() {
        return new EmailBuilder();
    }
}
