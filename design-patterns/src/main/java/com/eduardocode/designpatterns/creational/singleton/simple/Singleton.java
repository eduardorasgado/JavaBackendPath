package com.eduardocode.designpatterns.creational.singleton.simple;

public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

    public void printSomething() {
        System.out.println("This class is part of a singleton");
    }
}
