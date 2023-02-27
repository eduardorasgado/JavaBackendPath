package com.eduardocode.objectorienteddesign.designpatterns.structural.flyweight.errormessage;

public class SystemErrorMessage implements ErrorMessage {

    private final String messageTemplate;

    private final String helpUrlBase;

    public SystemErrorMessage(String messageTemplate, String helpUrlBase) {
        this.messageTemplate = messageTemplate;
        this.helpUrlBase = helpUrlBase;
    }

    @Override
    public String getText(String code) {
        return messageTemplate.replace("${errorCode}", code) + helpUrlBase + code;
    }
}
