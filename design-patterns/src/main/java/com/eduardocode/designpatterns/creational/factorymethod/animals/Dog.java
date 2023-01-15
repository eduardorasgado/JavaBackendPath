package com.eduardocode.designpatterns.creational.factorymethod.animals;

public class Dog extends Animal {
    @Override
    String makeSound() {
        return "Woof woof";
    }
}
