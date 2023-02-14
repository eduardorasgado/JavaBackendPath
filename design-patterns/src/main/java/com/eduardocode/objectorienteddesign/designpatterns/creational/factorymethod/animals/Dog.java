package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.animals;

public class Dog extends Animal {

    @Override
    String makeSound() {
        return "Woof woof";
    }

    @Override
    public String toString() {
        return "Dog: " + super.toString();
    }
}
