package com.eduardocode.objectorienteddesign.designpatterns.structural.flyweight.simple;

public class ConcreteFlyweight implements Flyweight {

    private FlyWeightType type;

    public ConcreteFlyweight(FlyWeightType type) {
        System.out.println("Flyweight type " + type.name() + " was created");

        this.type = type;
    }

    @Override
    public void performOperation() {
        System.out.println("Flyweight " + type.name() + " in operation");
    }
}
