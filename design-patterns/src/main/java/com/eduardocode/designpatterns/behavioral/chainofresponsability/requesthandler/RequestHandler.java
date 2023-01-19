package com.eduardocode.designpatterns.behavioral.chainofresponsability.requesthandler;

public abstract class RequestHandler {
    private RequestHandler nextHandler;

    public RequestHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(Request request);

    public RequestHandler getNextHandler() {
        return nextHandler;
    }
}
