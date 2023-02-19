package com.eduardocode.objectorienteddesign.designpatterns.creational.singleton.threadsafe.lazy.doublecheckedlocking;

import java.util.Objects;

public class LazyRegistryDCLDemo {

    public static void main(String[] args) {
        LazyRegistryDCL lazyRegistryDCL1 = LazyRegistryDCL.getInstance();
        LazyRegistryDCL lazyRegistryDCL2 = LazyRegistryDCL.getInstance();

        System.out.println(Objects.equals(lazyRegistryDCL1, lazyRegistryDCL2));
    }
}
