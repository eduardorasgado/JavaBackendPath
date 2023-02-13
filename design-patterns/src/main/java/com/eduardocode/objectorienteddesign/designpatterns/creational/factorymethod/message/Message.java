package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.message;

public abstract class Message {
    public abstract String getContent();

    public void addDefaultHeaders() {
        // Adds some default headers
        System.out.println("adding default headers to message...");
    }

    public void encrypt() {
        // Has some code to encrypt the content
        System.out.println("Encrypting message...");
    }

}
