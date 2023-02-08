package com.eduardocode.objectorienteddesign.designpatterns.structural.bridge.shapesandcolors;

public class Triangle extends Shape {
    public Triangle(Color color) {
        super(color);
    }

    @Override
    public void drawShape() {
        System.out.print("Drawing Triangle with color ");
        System.out.println(color.applyColor());
    }
}
