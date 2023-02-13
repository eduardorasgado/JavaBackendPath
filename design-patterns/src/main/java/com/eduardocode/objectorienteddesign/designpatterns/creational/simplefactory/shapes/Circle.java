package com.eduardocode.objectorienteddesign.designpatterns.creational.simplefactory.shapes;

public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing a Circle shape");
    }
}
