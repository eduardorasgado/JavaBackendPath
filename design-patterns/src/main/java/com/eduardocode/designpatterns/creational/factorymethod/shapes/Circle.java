package com.eduardocode.designpatterns.creational.factorymethod.shapes;

public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing a Circle shape");
    }
}