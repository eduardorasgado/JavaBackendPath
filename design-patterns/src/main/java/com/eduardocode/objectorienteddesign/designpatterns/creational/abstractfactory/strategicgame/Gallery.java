package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.strategicgame;

public class Gallery implements NavalUnit {
    @Override
    public void sail() {
        System.out.println("Galley is sailing using its sails and wind to move forward!");
    }
}
