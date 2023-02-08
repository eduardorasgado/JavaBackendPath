package com.eduardocode.objectorienteddesign.designpatterns.structural.bridge.shapesandcolors;

public class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    public void drawShape() {
        System.out.print("Drawing Circle with color ");
        System.out.println(color.applyColor());
    }
}
