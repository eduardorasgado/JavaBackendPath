package com.eduardocode.objectorienteddesign.designpatterns.behavioral.chainofresponsability.emails;

public class SalesHandler extends EmailHandler {

    public SalesHandler(EmailHandler next) {
        super(next);
    }

    @Override
    public void handle(String email) {
        if(isSales(email)) {
            System.out.println("This email is a sales email and will be sent to the sales folder");
        } else {
            getNext().handle(email);
        }
    }

    private boolean isSales(String email) {
        return email.contains("discount") || email.contains("sale") || email.contains("promotion");
    }
}
