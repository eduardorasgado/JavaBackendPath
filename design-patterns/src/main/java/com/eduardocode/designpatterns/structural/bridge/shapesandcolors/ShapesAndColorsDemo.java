package com.eduardocode.designpatterns.structural.bridge.shapesandcolors;

public class ShapesAndColorsDemo {

    public static void main(String[] args) {
        Shape triangleShape = new Triangle(new GreenColor());
        triangleShape.drawShape();

        Shape circleShape = new Circle(new RedColor());
        circleShape.drawShape();
    }
}
