package com.eduardocode.objectorienteddesign.designpatterns.structural.proxy.staticproxybitmap;

public class StaticProxyBitmapImageDemo {

    public static void main(String[] args) {
        Image image = ImageFactory.getImage("complex-graph.jpg");
        image.setLocation(new Point2D(10, 12));
        image.render();
        
        System.out.println("Image location: " + image.getLocation());
        image.render();
    }
}
