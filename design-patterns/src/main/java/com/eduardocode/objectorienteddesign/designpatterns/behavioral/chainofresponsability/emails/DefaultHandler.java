package com.eduardocode.objectorienteddesign.designpatterns.behavioral.chainofresponsability.emails;

public class DefaultHandler extends EmailHandler {

    public DefaultHandler(EmailHandler next) {
        super(next);
    }

    @Override
    public void handle(String email) {
        System.out.println("This email will be sent to the inbox folder");
    }
}
