package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.vehiclemechanics;

import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.vehiclemechanics.cylindersengine.factories.EightCylinderEngineFactory;
import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.vehiclemechanics.cylindersengine.factories.FourCylinderEngineFactory;
import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.vehiclemechanics.cylindersengine.factories.SixCylinderEngineFactory;
import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.vehiclemechanics.vehicles.Vehicle;
import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.vehiclemechanics.vehicles.factories.CarFactory;
import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.vehiclemechanics.vehicles.factories.EngineFactory;
import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.vehiclemechanics.vehicles.factories.TruckFactory;
import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.vehiclemechanics.vehicles.factories.VehicleFactory;

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
