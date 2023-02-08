package com.eduardocode.objectorienteddesign.designpatterns.behavioral.chainofresponsability.requesthandler;

public class RequestHandlerDemo {

    public static void main(String[] args) {
        RequestHandler chain = new ConcreteHandler1(new ConcreteHandler2(new DefaultHandler(null)));

        Request request1 = new Request("Type1", "Request 1");
        Request request2 = new Request("Type2", "Request 2");
        Request request3 = new Request("Type3", "Request 3");

        chain.handleRequest(request3);
        chain.handleRequest(request2);
        chain.handleRequest(request1);

        chain.handleRequest(request3);
        chain.handleRequest(request3);
        chain.handleRequest(request1);
    }
}
