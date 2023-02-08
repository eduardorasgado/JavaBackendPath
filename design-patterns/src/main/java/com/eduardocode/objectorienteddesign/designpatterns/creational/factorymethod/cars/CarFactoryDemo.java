package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.cars;

public class CarFactoryDemo {

    public static void main(String[] args) {
        Car car = CarFactory.createCar(CarFactory.CarType.SPORTS, "Pagani: Zonda", 2023, "Red");
        car.honk();
        car.drive();

        car = CarFactory.createCar(CarFactory.CarType.SEDAN, "Volkswagen: Jetta", 2022, "Grey");
        car.honk();
        car.drive();
    }
}
