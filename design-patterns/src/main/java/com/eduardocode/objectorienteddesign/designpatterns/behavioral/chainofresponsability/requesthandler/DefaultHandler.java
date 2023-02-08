package com.eduardocode.objectorienteddesign.designpatterns.behavioral.chainofresponsability.requesthandler;

public class DefaultHandler extends RequestHandler {

    public DefaultHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(Request request) {
        if(!request.isHandled()) {
            request.markHandled();

            System.out.println("DefaultHandler handled " + request.getDescription());
        }
    }
}
