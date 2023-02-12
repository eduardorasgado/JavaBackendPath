package com.eduardocode.objectorienteddesign.designpatterns.creational.builder.traditional.computer;

public class Computer {
    private String display;
    private String systemBlock;
    private String manipulators;

    public Computer() {
        display = null;
        systemBlock = null;
        manipulators = null;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public void setSystemBlock(String systemBlock) {
        this.systemBlock = systemBlock;
    }

    public void setManipulators(String manipulators) {
        this.manipulators = manipulators;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "display='" + display + '\'' +
                ", systemBlock='" + systemBlock + '\'' +
                ", manipulators='" + manipulators + '\'' +
                '}';
    }
}
