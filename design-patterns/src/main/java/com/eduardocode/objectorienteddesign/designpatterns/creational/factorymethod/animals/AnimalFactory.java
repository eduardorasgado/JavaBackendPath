package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.animals;

public abstract class AnimalFactory {

    public Animal getAnimal(String name) {
        Animal animal = createAnimal();
        animal.setName(name);

        return animal;
    }

    protected abstract Animal createAnimal();
}
