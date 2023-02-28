package com.eduardocode.objectorienteddesign.designpatterns.structural.proxy.dynamicproxybitmap;

public class DynamicProxyBitmapDemo {

    /**
     * Dynamic proxies are created using InvocationHandler from java reflect API
     *
     * The intention of the dynamic proxy is to allow us to create proxys for any object at runtime
     * @param args
     */
    public static void main(String[] args) {
        Image image = ImageFactory.getImage("myImage.png");
        image.setLocation(new Point2D(200, 1043));
        image.render();

        System.out.println("Image location: " + image.getLocation());
        image.render();
    }
}
