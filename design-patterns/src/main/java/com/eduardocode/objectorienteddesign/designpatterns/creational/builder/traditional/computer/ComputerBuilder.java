package com.eduardocode.objectorienteddesign.designpatterns.creational.builder.traditional.computer;


public abstract class ComputerBuilder {
    protected Computer computer;

    public Computer getComputer() {
        return computer;
    }

    public void createNewComputer() {
        computer = new Computer();
    }

    public abstract void buildSystemBlock();
    public abstract void buildDisplay();
    public abstract void buildManiputators();
}
