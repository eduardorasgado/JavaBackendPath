package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.message;

public class JsonMessage extends Message{
    @Override
    public String getContent() {
        return "{\"JSON]\":[]}";
    }
}
