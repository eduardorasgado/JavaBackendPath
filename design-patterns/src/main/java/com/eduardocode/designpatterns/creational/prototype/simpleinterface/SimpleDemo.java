package com.eduardocode.designpatterns.creational.prototype.simpleinterface;

public class SimpleDemo {

    public static void main(String[] args) {
        PropertyHolder<String> prototypeA = new ConcretePrototypeA("Hello");
        PropertyHolder<String> prototypeAClone = prototypeA.clone();

        System.out.println(prototypeA.getProperty());
        System.out.println(prototypeAClone.getProperty());

        prototypeAClone.setProperty("World");

        System.out.println(prototypeA.getProperty());
        System.out.println(prototypeAClone.getProperty());

        PropertyHolder<Integer> prototypeB = new ConcretePrototypeB(10);
        PropertyHolder<Integer> prototypeBClone = prototypeB.clone();

        System.out.println(prototypeB.getProperty());
        System.out.println(prototypeBClone.getProperty());

        prototypeBClone.setProperty(15);

        System.out.println(prototypeB.getProperty());
        System.out.println(prototypeBClone.getProperty());
    }
}
