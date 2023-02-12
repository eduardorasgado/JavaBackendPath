package com.eduardocode.objectorienteddesign.designpatterns.creational.builder.traditional.computer;

public class ExpensiveComputerBuilder extends ComputerBuilder {
    @Override
    public void buildSystemBlock() {
        computer.setSystemBlock("Expensive SB");
    }

    @Override
    public void buildDisplay() {
        computer.setDisplay("Expensive Display");
    }

    @Override
    public void buildManiputators() {
        computer.setManipulators("mouse + keyboard + second monitor");
    }
}
