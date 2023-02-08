package com.eduardocode.objectorienteddesign.designpatterns.structural.proxy.image;

public class ImageProxy implements Image {

    private RealImage realImage;
    private final String fileName;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null) {
            realImage = new RealImage(fileName);
        }

        realImage.display();
    }
}
