package com.eduardocode.objectorienteddesign.designpatterns.structural.decorator.message;

public class MessageDemo {

    public static void main(String[] args) {
        TextMessage message = new TextMessage("The <FORCE> is string with this one!");
        Base64EncodedMessage base64EncodedMessage = new Base64EncodedMessage(message);
        HtmlEncodedMessage htmlEncodedMessage = new HtmlEncodedMessage(base64EncodedMessage);

        System.out.println(message.getContent());
        System.out.println(base64EncodedMessage.getContent());
        System.out.println(htmlEncodedMessage.getContent());
    }
}
