package com.eduardocode.designpatterns.structural.composite.levels;

public class Leaf extends Level implements Component {
    private final String name;

    public Leaf(String name) {
        super(1);
        this.name = name;
    }

    @Override
    public void print() {
        printLevel();
        System.out.println("Component name: " + name);
    }
}
