package com.eduardocode.objectorienteddesign.designpatterns.behavioral.chainofresponsability.requesthandler;

public class Request {

    private final String type;
    private final String description;
    private boolean handled;

    public Request(String type, String description) {
        this.type = type;
        this.description = description;

        handled = false;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public boolean isHandled() {
        return handled;
    }

    public void markHandled() {
        handled = true;
    }
}
