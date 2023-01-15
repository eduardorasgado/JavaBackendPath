package com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.cylindersengine.factories;

import com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.vehicles.factories.EngineFactory;
import com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.cylindersengine.Engine;
import com.eduardocode.designpatterns.creational.abstractfactory.vehiclemechanics.cylindersengine.SixCylinderEngine;

public class SixCylinderEngineFactory implements EngineFactory {
    @Override
    public Engine createEngine() {
        return new SixCylinderEngine();
    }
}
