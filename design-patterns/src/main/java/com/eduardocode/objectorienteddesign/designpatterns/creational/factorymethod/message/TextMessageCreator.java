package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.message;

public class TextMessageCreator extends MessageCreator {
    @Override
    public Message createMessage() {
        return new TextMessage();
    }
}
