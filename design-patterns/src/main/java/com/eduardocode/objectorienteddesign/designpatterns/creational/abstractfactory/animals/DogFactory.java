package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.animals;

public class DogFactory implements AnimalFactory {

    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}
