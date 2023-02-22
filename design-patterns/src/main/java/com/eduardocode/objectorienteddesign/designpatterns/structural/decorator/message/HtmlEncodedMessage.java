package com.eduardocode.objectorienteddesign.designpatterns.structural.decorator.message;

public class HtmlEncodedMessage extends Message {

    public HtmlEncodedMessage(IMessage message) {
        super(message);
    }

    @Override
    public String getContent() {
        return "<div>" + super.getContent() + "<div>";
    }
}
