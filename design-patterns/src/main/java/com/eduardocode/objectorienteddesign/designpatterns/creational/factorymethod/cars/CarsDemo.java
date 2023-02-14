package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.cars;

public class CarsDemo {

    public static void main(String[] args) {
        CarFactory.Properties sedanCarProps = CarFactory.newPropertiesBuilder()
                .setModel("Sedan 202S")
                .setYear(2022)
                .setColor("Red")
                .build();
        System.out.println(testCarFactory(new SedanCarFactory(), sedanCarProps));

        CarFactory.Properties sportsCarProps = CarFactory.newPropertiesBuilder()
                .setModel("Zonda Pagani")
                .setYear(2023)
                .setColor("Blue")
                .build();
        System.out.println(testCarFactory(new SportsCarFactory(), sportsCarProps));
    }

    private static Car testCarFactory(CarFactory carFactory, CarFactory.Properties carProps) {
        return carFactory.create(carProps.getModel(), carProps.getYear(), carProps.getColor());
    }
}
