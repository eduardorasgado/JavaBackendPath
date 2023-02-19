package com.eduardocode.objectorienteddesign.designpatterns.creational.singleton.nonthreadsafe.eager;

import java.util.Objects;

public class EagerSingletonDemo {

    public static void main(String[] args) {
        EagerRegistry registry = EagerRegistry.getInstance();
        EagerRegistry registry2 = EagerRegistry.getInstance();

        System.out.println(Objects.equals(registry, registry2));
    }
}
