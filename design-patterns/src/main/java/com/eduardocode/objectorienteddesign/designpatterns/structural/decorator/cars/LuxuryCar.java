package com.eduardocode.objectorienteddesign.designpatterns.structural.decorator.cars;

public class LuxuryCar extends CarDecorator{
    public LuxuryCar(Car car) {
        super(car);
    }

    @Override
    public void drive() {
        super.drive();
        System.out.print(" And drives soft and smoth like a luxury car");
    }
}
