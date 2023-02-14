package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.animals;

public class DogFactory extends AnimalFactory {

    @Override
    protected Animal createAnimal() {
        return new Dog();
    }
}
