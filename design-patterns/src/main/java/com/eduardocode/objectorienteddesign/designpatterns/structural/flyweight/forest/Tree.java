package com.eduardocode.objectorienteddesign.designpatterns.structural.flyweight.forest;

import java.awt.*;

public class Tree {
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw(Graphics graphics) {
        getType().draw(graphics, getX(), getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TreeType getType() {
        return type;
    }
}
