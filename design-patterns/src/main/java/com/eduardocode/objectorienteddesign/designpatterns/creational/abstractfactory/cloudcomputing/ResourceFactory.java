package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.cloudcomputing;

public interface ResourceFactory {
    Instance createInstance(Instance.Capacity capacity);

    Storage createStorage(int capMib);
}
