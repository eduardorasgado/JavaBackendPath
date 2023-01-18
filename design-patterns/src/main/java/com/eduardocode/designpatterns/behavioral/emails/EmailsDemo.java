package com.eduardocode.designpatterns.behavioral.emails;

public class EmailsDemo {

    public static void main(String[] args) {
        EmailHandler chain = new SpamHandler(new SalesHandler(new DefaultHandler(null)));

        String email1 = "Get rich quick with our new pills";
        String email2 = "50% off all summer sales";
        String email3 = "Meeting schedule for next week";

        chain.handle(email1);
        chain.handle(email2);
        chain.handle(email3);
    }
}
