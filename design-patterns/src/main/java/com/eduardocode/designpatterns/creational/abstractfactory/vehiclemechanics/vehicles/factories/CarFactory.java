package com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.vehicles.factories;

import com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.vehicles.Car;
import com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.vehicles.Vehicle;

public class CarFactory implements VehicleFactory {
    private EngineFactory engineFactory;

    public CarFactory(EngineFactory engineFactory) {
        this.engineFactory = engineFactory;
    }

    @Override
    public Vehicle createVehicle() {
        return new Car(engineFactory);
    }
}
