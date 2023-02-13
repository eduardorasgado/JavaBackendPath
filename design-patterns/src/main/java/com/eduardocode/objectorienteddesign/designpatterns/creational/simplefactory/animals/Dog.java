package com.eduardocode.objectorienteddesign.designpatterns.creational.simplefactory.animals;

public class Dog extends Animal {
    @Override
    String makeSound() {
        return "Woof woof";
    }
}
