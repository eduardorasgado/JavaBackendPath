package com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics;

import com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.cylindersengine.factories.*;
import com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.vehicles.*;
import com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.vehicles.factories.*;

public class VehicleMechanicsDemo {

    public static void main(String[] args) {
        EngineFactory engineFactory = new FourCylinderEngineFactory();
        VehicleFactory vehicleFactory = new CarFactory(engineFactory);
        Vehicle vehicle = vehicleFactory.createVehicle();
        vehicle.drive();

        engineFactory = new SixCylinderEngineFactory();
        vehicleFactory = new TruckFactory(engineFactory);
        vehicle = vehicleFactory.createVehicle();
        vehicle.drive();

        engineFactory = new EightCylinderEngineFactory();
        vehicleFactory = new CarFactory(engineFactory);
        vehicle = vehicleFactory.createVehicle();
        vehicle.drive();
    }
}
