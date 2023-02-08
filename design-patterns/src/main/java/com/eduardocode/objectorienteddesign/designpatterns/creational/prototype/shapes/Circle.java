package com.eduardocode.objectorienteddesign.designpatterns.creational.prototype.shapes;

public class Circle extends Shape {
    private int radius;

    public Circle(String id, int radius) {
        super(id, "Circle");
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public Prototype clone() {
        return new Circle(getId(), radius);
    }
}
