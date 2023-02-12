package com.eduardocode.objectorienteddesign.designpatterns.creational.builder.traditional.computer;

public class ComputerDirector {
    private ComputerBuilder computerBuilder;

    public ComputerDirector() {}

    public ComputerDirector(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public void setComputerBuilder(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public void buildComputer() {
        computerBuilder.createNewComputer();
        
        computerBuilder.buildSystemBlock();
        computerBuilder.buildDisplay();
        computerBuilder.buildManiputators();
    }

    public Computer getComputer() {
        return computerBuilder.getComputer();
    }
}
