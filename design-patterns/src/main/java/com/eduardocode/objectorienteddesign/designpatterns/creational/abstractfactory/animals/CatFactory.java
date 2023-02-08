package com.eduardocode.objectorienteddesign.designpatterns.creational.abstractfactory.animals;

public class CatFactory implements AnimalFactory {

    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
