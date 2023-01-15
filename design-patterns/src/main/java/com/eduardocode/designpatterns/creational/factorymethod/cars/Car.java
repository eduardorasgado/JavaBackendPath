package com.eduardocode.designpatterns.creational.factorymethod.cars;

public abstract class Car {
    protected String model;
    protected int year;
    protected String color;

    public Car() {
    }

    public Car(String model, int year, String color) {
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public abstract void drive();

    public abstract void honk();

    protected void setModel(String model) {
        this.model = model;
    }

    protected void setYear(int year) {
        this.year = year;
    }

    protected void setColor(String color) {
        this.color = color;
    }
}
