package com.eduardocode.objectorienteddesign.designpatterns.creational.simplefactory.shapes;

public class ShapeDemo {

    public static void main(String[] args) {
        Shape shape = ShapeFactory.createShape(ShapeFactory.ShapeType.SQUARE);
        shape.draw();

        shape = ShapeFactory.createShape(ShapeFactory.ShapeType.RECTANGLE);
        shape.draw();

        shape = ShapeFactory.createShape(ShapeFactory.ShapeType.CIRCLE);
        shape.draw();
    }
}
