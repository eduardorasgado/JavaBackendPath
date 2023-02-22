package com.eduardocode.objectorienteddesign.designpatterns.structural.decorator.message;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64EncodedMessage extends Message {

    public Base64EncodedMessage(IMessage message) {
        super(message);
    }

    @Override
    public String getContent() {
        return Base64.getEncoder().encodeToString(super.getContent().getBytes(StandardCharsets.UTF_8));
    }
}
