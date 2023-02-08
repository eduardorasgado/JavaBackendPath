package com.eduardocode.objectorienteddesign.designpatterns.creational.singleton.threadsafe.iodh.simple;

import com.eduardocode.objectorienteddesign.designpatterns.creational.singleton.nonthreadsafe.simple.Singleton;

public class SingletonDemo {

    public static void main(String[] args) {
        com.eduardocode.objectorienteddesign.designpatterns.creational.singleton.nonthreadsafe.simple.Singleton singleton1 = com.eduardocode.objectorienteddesign.designpatterns.creational.singleton.nonthreadsafe.simple.Singleton.getInstance();
        com.eduardocode.objectorienteddesign.designpatterns.creational.singleton.nonthreadsafe.simple.Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1 == singleton2);

        singleton1.printSomething();
        singleton2.printSomething();
    }
}
