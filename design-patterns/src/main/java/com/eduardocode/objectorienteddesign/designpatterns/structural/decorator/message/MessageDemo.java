package com.eduardocode.objectorienteddesign.designpatterns.structural.decorator.message;

public class MessageDemo {

    public static void main(String[] args) {
        TextMessage message = new TextMessage("The <FORCE> is string with this one!");
        HtmlEncodedMessage htmlEncodedMessage = new HtmlEncodedMessage(message);
        Base64EncodedMessage base64EncodedMessage = new Base64EncodedMessage(htmlEncodedMessage);

        System.out.println(message.getContent());
        System.out.println(htmlEncodedMessage.getContent());
        System.out.println(base64EncodedMessage.getContent());
    }
}
