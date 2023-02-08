package com.eduardocode.objectorienteddesign.designpatterns.structural.flyweight.simple;

public class SimpleDemo {

    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        Flyweight fw = factory.getFlyweight(FlyWeightType.A);
        fw.performOperation();

        fw = factory.getFlyweight(FlyWeightType.B);
        fw.performOperation();

        fw = factory.getFlyweight(FlyWeightType.A);
        fw.performOperation();
        fw.performOperation();

    }
}
