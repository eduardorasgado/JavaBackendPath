package com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.vehicles;

import com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.cylindersengine.Engine;
import com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.vehicles.factories.EngineFactory;

public class Car implements Vehicle {
    private Engine engine;

    public Car(EngineFactory engineFactory) {
        engine = engineFactory.createEngine();
    }

    @Override
    public void drive() {
        System.out.println("Driving a car with " + String.valueOf(engine.getNumberOfCylinders()) + " cylinders.");
    }
}
