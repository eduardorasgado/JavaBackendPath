package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.shapes;

public class Circle implements Shape {
    private int radius;

    @Override
    public String getName() {
        return "Circle";
    }

    @Override
    public String accept(ExportVisitor visitor) {
        return visitor.visit(this);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
