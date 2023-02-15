package com.eduardocode.objectorienteddesign.designpatterns.structural.flyweight.forest;

import java.awt.*;

public class TreeType {
    private String name;
    private Color color;
    private String details;

    public TreeType(String name, Color color, String details) {
        this.name = name;
        this.color = color;
        this.details = details;
    }

    public void draw(Graphics graphics, int x, int y) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(x - 1, y, 3, 5);
        graphics.setColor(getColor());
        graphics.fillOval(x - 5, y - 10, 10, 10);
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public String getDetails() {
        return details;
    }
}
