package com.eduardocode.objectorienteddesign.designpatterns.structural.decorator.cars;

public abstract class CarDecorator implements Car {
    private Car wrappedCar;

    public CarDecorator(Car wrappedCar) {
        this.wrappedCar = wrappedCar;
    }

    @Override
    public void drive() {
        wrappedCar.drive();
    }
}
