package com.eduardocode.designpatterns.structural.proxy.image;

public class ImageDemo {

    public static void main(String[] args) {
        Image image = new ImageProxy("test_image.png");

        image.display();
        image.display();
    }
}
