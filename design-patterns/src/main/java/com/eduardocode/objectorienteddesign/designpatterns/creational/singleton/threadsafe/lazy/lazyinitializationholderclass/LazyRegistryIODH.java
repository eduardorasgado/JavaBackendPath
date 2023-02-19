package com.eduardocode.objectorienteddesign.designpatterns.creational.singleton.threadsafe.lazy.lazyinitializationholderclass;

public class LazyRegistryIODH {

    private LazyRegistryIODH() {
        System.out.println(getClass().getSimpleName() + " object was created");
    }

    private static class RegistryHolder {
        private static LazyRegistryIODH INSTANCE = new LazyRegistryIODH();
    }

    public static LazyRegistryIODH getInstance() {
        return RegistryHolder.INSTANCE;
    }
}
