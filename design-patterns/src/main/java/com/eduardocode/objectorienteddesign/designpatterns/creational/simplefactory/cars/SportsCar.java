package com.eduardocode.objectorienteddesign.designpatterns.creational.simplefactory.cars;

public class SportsCar extends Car {

    public SportsCar(String model, int year, String color) {
        super(model, year, color);
    }

    public SportsCar() {

    }

    @Override
    public void drive() {
        System.out.println("Speeding down the highway in my " + color + " " + model + " sports car.");
    }

    @Override
    public void honk() {
        System.out.println("Beep beep! Watch out, Im driving my " + color + " " + model + " sports car.");
    }
}
