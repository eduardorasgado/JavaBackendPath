package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.message;

public class JsonMessageCreator extends MessageCreator {
    @Override
    public Message createMessage() {
        return new JsonMessage();
    }
}
