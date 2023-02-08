package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.vehiclemechanics.cylindersengine.factories;

import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.vehiclemechanics.cylindersengine.EightCylinderEngine;
import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.vehiclemechanics.cylindersengine.Engine;
import com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.vehiclemechanics.vehicles.factories.EngineFactory;

public class EightCylinderEngineFactory implements EngineFactory {
    @Override
    public Engine createEngine() {
        return new EightCylinderEngine();
    }
}
