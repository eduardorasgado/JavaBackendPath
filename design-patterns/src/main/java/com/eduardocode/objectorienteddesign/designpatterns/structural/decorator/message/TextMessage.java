package com.eduardocode.objectorienteddesign.designpatterns.structural.decorator.message;

public class TextMessage implements IMessage {

    private String message;

    public TextMessage(String message) {
        this.message = message;
    }

    @Override
    public String getContent() {
        return message;
    }
}
