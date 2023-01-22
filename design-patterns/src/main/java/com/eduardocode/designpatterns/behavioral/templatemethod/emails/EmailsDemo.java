package com.eduardocode.designpatterns.behavioral.templatemethod.emails;

public class EmailsDemo {

    public static void main(String[] args) {
        Email email = new MarketingEmail("customer@example.com", "Summer Sale");
        email.send();

        System.out.println();

        email = new TransactionalEmail("cutomer2@Example.com", "TX1002");
        email.send();
    }
}
