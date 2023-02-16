package com.eduardocode.objectorienteddesign.designpatterns.structural.proxy.internet;

public class DefaultInternet implements Internet {

    @Override
    public void connectToHost(String host) {
        System.out.println("Connecting to " + host);
    }
}
