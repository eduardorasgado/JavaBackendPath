package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.cloudcomputing;

public interface Instance {
    enum Capacity{
        MICRO, SMALL, LARGE;
    }

    void start();

    void attachStorage(Storage storage);

    void stop();
}
