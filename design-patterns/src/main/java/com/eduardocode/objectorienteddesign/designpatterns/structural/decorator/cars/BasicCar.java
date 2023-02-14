package com.eduardocode.objectorienteddesign.designpatterns.structural.decorator.cars;

public class BasicCar implements Car {

    @Override
    public void drive() {
        System.out.print("Basic Car drives");
    }
}
