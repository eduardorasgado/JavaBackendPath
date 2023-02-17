package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.strategicgame;

public class Ironclad implements NavalUnit {
    @Override
    public void sail() {
        System.out.println("Ironclad is sailing at high speed and shooting with cannons!");
    }
}
