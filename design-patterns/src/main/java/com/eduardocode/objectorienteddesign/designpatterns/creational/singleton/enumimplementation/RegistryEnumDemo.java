package com.eduardocode.objectorienteddesign.designpatterns.creational.singleton.enumimplementation;

public class RegistryEnumDemo {
    public static void main(String[] args) {
        RegistryEnum singleton = RegistryEnum.INSTANCE;

        singleton.getConfiguration();
    }
}
