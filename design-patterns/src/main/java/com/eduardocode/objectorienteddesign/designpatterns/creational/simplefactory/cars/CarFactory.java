package com.eduardocode.objectorienteddesign.designpatterns.creational.simplefactory.cars;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CarFactory {
    
    private static final Map<CarType, Function<CarAttributeHolder, Car>> carTypeSupplierMap;

    public enum CarType {
        SPORTS,
        SEDAN;
    }

    static {
        carTypeSupplierMap = new HashMap<>();

        carTypeSupplierMap.put(
                CarType.SPORTS,
                (carAttrHolder) -> new SportsCar(carAttrHolder.getModel(), carAttrHolder.getYear(), carAttrHolder.getColor())
        );

        carTypeSupplierMap.put(
                CarType.SEDAN,
                (carAttrHolder) -> new SedanCar(carAttrHolder.getModel(), carAttrHolder.getYear(), carAttrHolder.getColor())
        );
    }
    
    public static Car createCar(CarType type, String model, int year, String color) {
        return carTypeSupplierMap.get(type).apply(new CarAttributeHolder(model, year, color));
    }
}
