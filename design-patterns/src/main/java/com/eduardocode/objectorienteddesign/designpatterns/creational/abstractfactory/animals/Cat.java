package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.animals;

public class Cat implements Animal {
    @Override
    public String getAnimalName() {
        return "Cat";
    }

    @Override
    public String makeSound() {
        return "Meow!";
    }
}
