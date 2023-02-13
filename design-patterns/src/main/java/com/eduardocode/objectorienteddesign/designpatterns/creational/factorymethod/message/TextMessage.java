package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.message;

public class TextMessage extends Message {

    @Override
    public String getContent() {
        return "Text";
    }
}
