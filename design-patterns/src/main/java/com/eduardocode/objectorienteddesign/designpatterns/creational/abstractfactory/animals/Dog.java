package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.animals;

public class Dog implements Animal {

    @Override
    public String getAnimalName() {
        return "Dog";
    }

    @Override
    public String makeSound() {
        return "Woof!";
    }
}
