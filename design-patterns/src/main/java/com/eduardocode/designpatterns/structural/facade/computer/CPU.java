package com.eduardocode.designpatterns.structural.facade.computer;

public class CPU {

    public void freeze() {
        System.out.println("Freezing CPU...");
    }

    public void execute() {
        System.out.println("Executing the program...");
    }
}
