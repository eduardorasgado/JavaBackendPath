package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.animals;

public class Cat extends Animal {
    @Override
    String makeSound() {
        return "Meow";
    }
}