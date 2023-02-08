package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.shapes;

public class Rectangle implements Shape {

    private int height;
    private int width;

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public String accept(ExportVisitor visitor) {
        return visitor.visit(this);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
