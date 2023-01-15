package com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.cylindersengine.factories;

import com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.vehicles.factories.EngineFactory;
import com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.cylindersengine.EightCylinderEngine;
import com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.cylindersengine.Engine;

public class EightCylinderEngineFactory implements EngineFactory {
    @Override
    public Engine createEngine() {
        return new EightCylinderEngine();
    }
}
