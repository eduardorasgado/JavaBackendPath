package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.strategicgame;

public class StrategicGameDemo {

    public static void main(String[] args) {
        System.out.println("Testing medieval classes: ");
        testAbstractFactory(new MedievalGameUnitFactory());

        System.out.println("\nTesting industrial classes: ");
        testAbstractFactory(new IndustrialAgeGameUniFactory());
    }

    private static void testAbstractFactory(GameUnitFactory factory) {
        LandUnit landUnit = factory.createLandUnit();
        NavalUnit navalUnit = factory.createNavalUnit();

        landUnit.attack();
        navalUnit.sail();
    }
}
