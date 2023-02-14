package com.eduardocode.objectorienteddesign.designpatterns.structural.decorator.cars;

public class CarsDemo {

    public static void main(String[] args) {
        Car basicCar = new BasicCar();
        basicCar.drive();
        System.out.println("\n---------");

        SportsCar sportsCar = new SportsCar(basicCar);
        sportsCar.drive();
        sportsCar.setTransmissionMode("sport+");
        System.out.println("\n---------");

        LuxuryCar sportsLuxuryCar = new LuxuryCar(sportsCar);
        sportsLuxuryCar.drive();
        System.out.println("\n---------");

        Car luxurySportsCar = new SportsCar(new LuxuryCar(new BasicCar()));
        luxurySportsCar.drive();
    }
}
