package com.eduardocode.designpatterns.creational.factorymethod.cars;

public class SedanCar extends Car {

    public SedanCar(String model, int year, String color) {
        super(model, year, color);
    }

    @Override
    public void drive() {
        System.out.println("Cruising around town in my " + color + " " + model + " sedan.");
    }

    @Override
    public void honk() {
        System.out.println("Honk honk! Making my way in my " + color + " " + model + " sedan.");
    }
}
