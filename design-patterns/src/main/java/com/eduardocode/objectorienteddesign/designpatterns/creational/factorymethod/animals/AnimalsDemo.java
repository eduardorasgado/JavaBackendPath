package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.animals;

public class AnimalsDemo {

    public static void main(String[] args) {
        System.out.println(testAnimalFactory(new CatFactory(), "Laisha"));
        System.out.println(testAnimalFactory(new DogFactory(), "Tobby"));
    }

    private static Animal testAnimalFactory(AnimalFactory animalFactory, String name) {
        return animalFactory.getAnimal(name);
    }
}
