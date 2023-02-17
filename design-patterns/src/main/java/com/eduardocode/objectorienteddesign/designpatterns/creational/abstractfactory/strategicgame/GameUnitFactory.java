package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.strategicgame;

public interface GameUnitFactory {
    LandUnit createLandUnit();
    NavalUnit createNavalUnit();
}
