package com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.cylindersengine.factories;

import com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.vehicles.factories.EngineFactory;
import com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.cylindersengine.Engine;
import com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.cylindersengine.FourCylinderEngine;

public class FourCylinderEngineFactory implements EngineFactory {
    @Override
    public Engine createEngine() {
        return new FourCylinderEngine();
    }
}
