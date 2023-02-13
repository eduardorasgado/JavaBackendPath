package com.eduardocode.objectorienteddesign.designpatterns.creational.simplefactory.animals;

public class Cat extends Animal {
    @Override
    String makeSound() {
        return "Meow";
    }
}
