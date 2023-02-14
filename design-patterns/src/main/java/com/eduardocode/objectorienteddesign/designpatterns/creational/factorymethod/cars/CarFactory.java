package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.cars;

public interface CarFactory {

    Car create(String model, int year, String color);
}
