package com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.vehicles.factories;

import com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.vehicles.Truck;
import com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.vehicles.Vehicle;

public class TruckFactory implements VehicleFactory {
    private EngineFactory engineFactory;
    public TruckFactory(EngineFactory engineFactory) {
        this.engineFactory = engineFactory;
    }

    @Override
    public Vehicle createVehicle() {
        return new Truck(engineFactory);
    }
}
