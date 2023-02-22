package com.eduardocode.objectorienteddesign.designpatterns.structural.decorator.message;

public abstract class Message implements IMessage {
    private final IMessage message;

    public Message(IMessage message) {
        this.message = message;
    }

    @Override
    public String getContent() {
        return message.getContent();
    }
}
