package com.eduardocode.objectorienteddesign.designpatterns.creational.singleton.threadsafe.lazy.doublecheckedlocking;

import static java.util.Objects.isNull;

public class LazyRegistryDCL {

    private LazyRegistryDCL() {}

    /*
        volatile keyword:
        To avoid threads tries to cache the value of the instance
        Indicates threads to not use the cashed value
        It forces value read/write from main memory instead of cache
     */
    private static volatile LazyRegistryDCL INSTANCE;

    /*
        Double-checked locking singleton implementation
     */
    public static LazyRegistryDCL getInstance() {
        if(isNull(INSTANCE)) {
            synchronized (LazyRegistryDCL.class) {
                if(isNull(INSTANCE)) {
                    INSTANCE = new LazyRegistryDCL();
                }
            }
        }

        return INSTANCE;
    }
}
