package com.eduardocode.designpatterns.behavioral.chainofresponsability.requesthandler;

public class ConcreteHandler1 extends RequestHandler {
    private final String TYPE = "Type1";

    public ConcreteHandler1(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(Request request) {
        if(TYPE.equals(request.getType()) && !request.isHandled()) {
            request.markHandled();

            System.out.println("ConcreteHandler1 handled" + request.getDescription());
        } else {
            getNextHandler().handleRequest(request);
        }
    }
}
