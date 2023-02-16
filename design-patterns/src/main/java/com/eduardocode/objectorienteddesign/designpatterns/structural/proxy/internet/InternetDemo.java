package com.eduardocode.objectorienteddesign.designpatterns.structural.proxy.internet;

public class InternetDemo {

    public static void main(String[] args) {
        Internet internet = new ProxyInternet();

        internet.connectToHost("google.sites/company");
        internet.connectToHost("facebook.com");
    }
}
