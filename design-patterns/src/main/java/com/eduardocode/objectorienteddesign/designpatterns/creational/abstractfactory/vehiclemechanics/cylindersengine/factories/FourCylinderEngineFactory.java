package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.vehiclemechanics.cylindersengine.factories;

import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.vehiclemechanics.cylindersengine.Engine;
import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.vehiclemechanics.cylindersengine.FourCylinderEngine;
import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.vehiclemechanics.vehicles.factories.EngineFactory;

public class FourCylinderEngineFactory implements EngineFactory {
    @Override
    public Engine createEngine() {
        return new FourCylinderEngine();
    }
}
