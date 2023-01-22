package com.eduardocode.designpatterns.behavioral.templatemethod.emails;

public abstract class Email {
    private String receiverEmail;

    public Email(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public final void send() {
        setSender();
        setReceiver();
        setSubject();
        setBody();
        setAttachment();
        System.out.println("Email sent");
    }

    protected void setReceiver() {
        System.out.println("Receiver: " + getReceiverEmail());
    }

    protected abstract void setSender();

    protected abstract void setSubject();

    protected abstract void setBody();

    protected abstract void setAttachment();

    protected String getReceiverEmail() {
        return receiverEmail;
    }
}
