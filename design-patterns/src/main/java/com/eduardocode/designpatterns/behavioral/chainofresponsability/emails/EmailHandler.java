package com.eduardocode.designpatterns.behavioral.chainofresponsability.emails;

public abstract class EmailHandler {
    private final EmailHandler next;

    public EmailHandler(EmailHandler next) {
        this.next = next;
    }

    public abstract void handle(String email);

    public EmailHandler getNext() {
        return next;
    }
}
