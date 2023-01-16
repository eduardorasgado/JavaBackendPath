package com.eduardocode.designpatterns.creational.prototype.shapes;

public class Square extends Shape {
    private int side;

    public Square(String id, int side) {
        super(id, "Square");
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public Prototype clone() {
        return new Square(getId(), side);
    }
}
