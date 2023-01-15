package com.eduardocode.designpatterns.creational.singleton.threadsafe.doublecheckedlocking.simple;

public class SingletonDemo {

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1 == singleton2);

        singleton1.printSomething();
        singleton2.printSomething();
    }
}
