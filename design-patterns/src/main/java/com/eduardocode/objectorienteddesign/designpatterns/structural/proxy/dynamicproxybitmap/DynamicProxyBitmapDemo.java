package com.eduardocode.objectorienteddesign.designpatterns.structural.proxy.dynamicproxybitmap;

public class DynamicProxyBitmapDemo {

    public static void main(String[] args) {
        // using dynamic proxy java API
        Image image = ImageFactory.getImage("myImage.png");
        image.setLocation(new Point2D(200, 1043));
        image.render();

        System.out.println("Image location: " + image.getLocation());
        image.render();
    }
}
