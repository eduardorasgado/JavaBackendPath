package com.eduardocode.objectorienteddesign.designpatterns.creational.prototype.shapes;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(String id, int width, int height) {
        super(id, "Rectangle");
        this.width = width;
        this.height = height;

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public Prototype clone() {
        return new Rectangle(getId(), width, height);
    }
}
