package com.eduardocode.objectorienteddesign.designpatterns.behavioral.chainofresponsability.requesthandler;

public class ConcreteHandler2 extends RequestHandler {
    private final String TYPE = "Type2";

    public ConcreteHandler2(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(Request request) {
        if(TYPE.equals(request.getType()) && !request.isHandled()) {
            request.markHandled();

            System.out.println("ConcreteHandler2 handled " + request.getDescription());
        } else {
            getNextHandler().handleRequest(request);
        }
    }
}
