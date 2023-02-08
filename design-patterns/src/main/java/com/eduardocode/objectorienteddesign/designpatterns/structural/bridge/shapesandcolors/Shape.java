package com.eduardocode.objectorienteddesign.designpatterns.structural.bridge.shapesandcolors;

public abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract public void drawShape();
}
