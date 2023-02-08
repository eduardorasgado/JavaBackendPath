package com.eduardocode.objectorienteddesign.designpatterns.creational.factorymethod.animals;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class AnimalFactory {
    private static Map<AnimalType, Supplier<Animal>> animalMap;

    public enum AnimalType {
        DOG,
        CAT;
    }

    static {
        animalMap  = new HashMap<>();

        animalMap.put(AnimalType.DOG, Dog::new);
        animalMap.put(AnimalType.CAT, Cat::new);
    }

    public static Animal getAnimal(AnimalType animal) {
        return animalMap.get(animal).get();
    }
}
