package com.eduardocode.objectorienteddesign.designpatterns.creational.simplefactory.cars;

public class CarAttributeHolder {
    private String model;
    private int year;
    private String color;

    public CarAttributeHolder(String model, int year, String color) {
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }
}
