package com.eduardocode.objectorienteddesign.designpatterns.structural.composite.shapeeditorgui;

import java.awt.*;

public class Circle extends BaseShape {
    private int radius;

    public Circle(int x, int y, int radius, Color color) {
        super(x, y, color);
        this.radius = radius;
    }

    @Override
    public int getWidth() {
        return getDiameter();
    }

    @Override
    public int getHeight() {
        return getDiameter();
    }

    private int getDiameter() {
        return radius * 2;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.drawOval(getX(), getY(), getWidth() - 1, getHeight() -1);

    }
}
