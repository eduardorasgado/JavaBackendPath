package com.eduardocode.objectorienteddesign.designpatterns.creational.simplefactory.shapes;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle shape");
    }
}
