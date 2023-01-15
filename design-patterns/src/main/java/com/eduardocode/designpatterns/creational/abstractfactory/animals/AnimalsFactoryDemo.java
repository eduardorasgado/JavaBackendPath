package com.eduardocode.designpatterns.creational.abstractfactory.animals;

public class AnimalsFactoryDemo {

    public static void main(String[] args) {
        AnimalFactory animalFactory = new DogFactory();
        Animal animal = animalFactory.createAnimal();
        System.out.printf("Name: %s%n", animal.getAnimalName());
        System.out.printf("Sound: %s%n", animal.makeSound());

        animalFactory = new CatFactory();
        animal = animalFactory.createAnimal();
        System.out.printf("Name: %s%n", animal.getAnimalName());
        System.out.printf("Sound: %s%n", animal.makeSound());
    }
}
