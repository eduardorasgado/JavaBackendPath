package com.eduardocode.designpatterns.creational.prototype.shapes;

public class ShapeDemo {

    public static void main(String[] args) {
        Shape square = new Square("1", 10);
        Shape circle = new Circle("2", 5);
        Shape rectangle = new Rectangle("3", 15, 20);

        Shape squareClone = (Shape) square.clone();
        Shape circleClone = (Shape) circle.clone();
        Shape rectangleClone = (Shape) rectangle.clone();

        System.out.println("Shape: " + square.getType()
                + ", id: " + square.getId()
                + ", side: " + ((Square) square).getSide());
        System.out.println("Shape: " + squareClone.getType()
                + ", id: " + squareClone.getId()
                + ", side: " + ((Square) squareClone).getSide());


        System.out.println("Shape: " + circle.getType()
                + ", id: " + circle.getId()
                + ", radius: " + ((Circle) circle).getRadius());
        System.out.println("Shape: " + circleClone.getType()
                + ", id: " + circleClone.getId()
                + ", radius: " + ((Circle) circleClone).getRadius());


        System.out.println("Shape: " + rectangle.getType()
                + ", id: " + rectangle.getId()
                + ", width: " + ((Rectangle) rectangle).getWidth()
                + ", height: " + ((Rectangle) rectangle).getHeight());
        System.out.println("Shape: " + rectangleClone.getType()
                + ", id: " + rectangleClone.getId()
                + ", width: " + ((Rectangle) rectangleClone).getWidth()
                + ", height: " + ((Rectangle) rectangleClone).getHeight());
    }
}
