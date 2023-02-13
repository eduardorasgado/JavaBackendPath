package com.eduardocode.objectorienteddesign.designpatterns.creational.simplefactory.animals;

public class AnimalFactoryDemo {

    public static void main(String[] args) {
        Animal animal = AnimalFactory.getAnimal(AnimalFactory.AnimalType.DOG);
        System.out.println(animal.makeSound());

        animal = AnimalFactory.getAnimal(AnimalFactory.AnimalType.CAT);
        System.out.println(animal.makeSound());
    }
}
