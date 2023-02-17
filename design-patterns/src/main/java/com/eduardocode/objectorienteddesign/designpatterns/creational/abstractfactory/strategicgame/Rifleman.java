package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.strategicgame;

public class Rifleman implements LandUnit {

    @Override
    public void attack() {
        System.out.println("Rifleman is shooting everybody!");
    }
}
