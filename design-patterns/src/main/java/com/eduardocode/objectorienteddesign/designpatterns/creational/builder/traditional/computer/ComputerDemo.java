package com.eduardocode.objectorienteddesign.designpatterns.creational.builder.traditional.computer;

public class ComputerDemo {

    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();

        director.setComputerBuilder(new CheapComputerBuilder());
        director.buildComputer();
        Computer computer = director.getComputer();
        System.out.println(computer);

        director.setComputerBuilder(new ExpensiveComputerBuilder());
        director.buildComputer();
        computer = director.getComputer();
        System.out.println(computer);
    }
}
