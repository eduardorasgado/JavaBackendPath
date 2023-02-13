package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.message;

public abstract class MessageCreator {

    // This method is not mandatory but helps to perform certain processing before delivering object created
    public Message getMessage() {
        Message message = createMessage();
        message.addDefaultHeaders();
        message.encrypt();

        return message;
    }

    protected abstract Message createMessage();
}
