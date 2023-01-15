package com.eduardocode.designpatterns.creational.factorymethod.cars;

public abstract class Car {
    protected String model;
    protected int year;
    protected String color;

    public Car(String model, int year, String color) {
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public abstract void drive();

    public abstract void honk();
}
