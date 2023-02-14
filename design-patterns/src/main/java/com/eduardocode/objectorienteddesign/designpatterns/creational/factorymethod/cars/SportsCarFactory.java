package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.cars;

public class SportsCarFactory extends CarFactory {

    @Override
    public Car create(String model, int year, String color) {
        return new SportsCar(model, year, color);
    }
}
