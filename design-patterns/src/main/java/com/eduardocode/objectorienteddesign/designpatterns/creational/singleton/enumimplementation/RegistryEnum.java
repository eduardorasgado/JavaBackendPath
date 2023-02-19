package com.eduardocode.objectorienteddesign.designpatterns.creational.singleton.enumimplementation;

/*
    It handles serialization and deserialization really well, if need it
 */
public enum RegistryEnum {

    INSTANCE;

    public void getConfiguration() {
        System.out.println("Here you have your configs");
    }
}
