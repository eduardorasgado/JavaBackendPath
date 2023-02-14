package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.animals;

public class CatFactory extends AnimalFactory {

    @Override
    protected Animal createAnimal() {
        return new Cat();
    }
}
