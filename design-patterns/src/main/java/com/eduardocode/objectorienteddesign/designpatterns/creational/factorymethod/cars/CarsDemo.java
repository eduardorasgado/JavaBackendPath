package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.cars;

public class CarsDemo {

    public static void main(String[] args) {
        System.out.println(testCarFactory(new SedanFactory(), "202S", 2022, "Red"));
    }

    private static Car testCarFactory(CarFactory carFactory, String model, int year, String color) {
        return carFactory.create(model, year, color);
    }
}
