package com.eduardocode.objectorienteddesign.designpatterns.structural.proxy.staticproxybitmap;

public class ImageFactory {

    public static Image getImage(String name) {
        return new ImageProxy(name);
    }
}
