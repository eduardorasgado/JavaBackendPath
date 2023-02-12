package com.eduardocode.objectorienteddesign.designpatterns.creational.builder.traditional.computer;

public class CheapComputerBuilder extends ComputerBuilder {

    @Override
    public void buildSystemBlock() {
        computer.setSystemBlock("Cheap SB");
    }

    @Override
    public void buildDisplay() {
        computer.setDisplay("Cheap Display");
    }

    @Override
    public void buildManiputators() {
        computer.setManipulators("mouse + keyboard");
    }
}
