package com.eduardocode.objectorienteddesign.designpatterns.structural.decorator.cars;

public class SportsCar extends CarDecorator {
    private String transmissionMode;

    public SportsCar(Car car) {
        super(car);
    }

    @Override
    public void drive() {
        super.drive();
        System.out.print(" And drive fast like a sports car");
    }

    public void setTransmissionMode(String transmissionMode) {
        this.transmissionMode = transmissionMode;
    }
}
