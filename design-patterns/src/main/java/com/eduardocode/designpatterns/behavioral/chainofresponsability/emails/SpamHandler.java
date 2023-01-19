package com.eduardocode.designpatterns.behavioral.chainofresponsability.emails;

public class SpamHandler extends EmailHandler {


    public SpamHandler(EmailHandler next) {
        super(next);
    }

    @Override
    public void handle(String email) {
        if(isSpam(email)) {
            System.out.println("This email is a spam email and will be sent to the spam folder");
        } else {
            getNext().handle(email);
        }
    }

    private boolean isSpam(String email) {
        return email.contains("viagra") || email.contains("pills") || email.contains("free money");
    }
}
