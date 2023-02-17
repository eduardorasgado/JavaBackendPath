package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.strategicgame;

public class IndustrialAgeGameUniFactory implements GameUnitFactory {
    @Override
    public LandUnit createLandUnit() {
        return new Rifleman();
    }

    @Override
    public NavalUnit createNavalUnit() {
        return new Ironclad();
    }
}
