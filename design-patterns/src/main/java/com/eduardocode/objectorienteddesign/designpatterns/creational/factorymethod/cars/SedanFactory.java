package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.cars;

public class SedanFactory implements CarFactory {
    @Override
    public Car create(String model, int year, String color) {
        return new SedanCar(model, year, color);
    }
}
