package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.vehiclemechanics.vehicles;

import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.vehiclemechanics.cylindersengine.Engine;
import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.vehiclemechanics.vehicles.factories.EngineFactory;

public class Truck implements Vehicle {
    private Engine engine;

    public Truck(EngineFactory engineFactory) {
        engine = engineFactory.createEngine();
    }

    @Override
    public void drive() {
        System.out.println("Driving a truck with " + String.valueOf(engine.getNumberOfCylinders()) + " cylinders.");
    }
}
