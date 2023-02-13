package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.message;

public class MessageDemo {

    public static void main(String[] args) {
        printMessage(new JsonMessageCreator());
        printMessage(new TextMessageCreator());
    }

    public static void printMessage(MessageCreator creator) {
        Message message = creator.getMessage();

        System.out.println(message.getClass().getSimpleName());
        System.out.println(message.getContent());
        System.out.println();
    }
}
