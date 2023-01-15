package com.eduardocode.designpatterns.creational.abstractfactory.animals;

public class CatFactory implements AnimalFactory {

    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
