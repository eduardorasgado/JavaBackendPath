package com.eduardocode.designpatterns.creational.singleton.threadsafe.iodh.simple;

public class Singleton {

    private Singleton() {
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void printSomething() {
        System.out.println("This is a method from a IODH singleton class");
    }
}
