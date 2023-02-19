package com.eduardocode.objectorienteddesign.designpatterns.creational.singleton.threadsafe.lazy.lazyinitializationholderclass;

public class LazyRegistryIODHDemo {

    public static void main(String[] args) {
        LazyRegistryIODH singleton;

        singleton = LazyRegistryIODH.getInstance();
        singleton = LazyRegistryIODH.getInstance();
        singleton = LazyRegistryIODH.getInstance();
    }
}
