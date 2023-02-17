package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.strategicgame;


public class MedievalGameUnitFactory implements GameUnitFactory {
    @Override
    public LandUnit createLandUnit() {
        return new Swordsman();
    }

    @Override
    public NavalUnit createNavalUnit() {
        return new Gallery();
    }
}
