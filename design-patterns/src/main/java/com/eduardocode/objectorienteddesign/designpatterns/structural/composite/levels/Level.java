package com.eduardocode.objectorienteddesign.designpatterns.structural.composite.levels;

public class Level {
    private int level;

    public Level(int level) {
        this.level = level;
    }

    protected int getLevel() {
        return level;
    }

    protected void setLevel(int level) {
        this.level = level;
    }

    protected void printLevel() {
        for (int i = 0; i < getLevel(); i++) {
            System.out.print("> ");
        }
    }
}
