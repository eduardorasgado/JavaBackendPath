package com.eduardocode.designpatterns.creational.factorymethod.cars;

import java.sql.SQLOutput;

public class SportsCar extends Car {

    public SportsCar(String model, int year, String color) {
        super(model, year, color);
    }

    @Override
    public void drive() {
        System.out.println("Speeding down the highway in my" + color + " " + model + " sports car.");
    }

    @Override
    public void honk() {
        System.out.println("Beep beep! Watch out, Im driving my " + color + " " + model + " sports car.");
    }
}
