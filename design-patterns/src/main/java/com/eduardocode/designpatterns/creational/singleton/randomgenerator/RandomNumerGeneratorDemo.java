package com.eduardocode.designpatterns.creational.singleton.randomgenerator;

public class RandomNumerGeneratorDemo {

    public static void main(String[] args) {
        RandomNumberGenerator randomNumberGenerator1 = RandomNumberGenerator.getInstance();
        RandomNumberGenerator randomNumberGenerator2 = RandomNumberGenerator.getInstance();

        System.out.println(randomNumberGenerator1.equals(randomNumberGenerator2));

        System.out.println(randomNumberGenerator1.generateRandomNumber(3, 5));
        System.out.println(randomNumberGenerator2.generateRandomNumber(500, 1000));
    }
}
