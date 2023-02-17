package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.strategicgame;

public class Swordsman implements LandUnit {
    @Override
    public void attack() {
        System.out.println("Swordsman is slicing everybody using a powerful sword!");
    }
}
