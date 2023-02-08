package com.eduardocode.objectorienteddesign.designpatterns.creational.singleton.threadsafe.doublecheckedlocking.simple;

public class Singleton {
    private static volatile  Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

    public void printSomething() {
        System.out.println("This is a method from a double checked locking singleton class");
    }
}
