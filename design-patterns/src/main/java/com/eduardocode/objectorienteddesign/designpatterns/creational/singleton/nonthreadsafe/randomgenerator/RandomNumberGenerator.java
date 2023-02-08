package com.eduardocode.objectorienteddesign.designpatterns.creational.singleton.nonthreadsafe.randomgenerator;

import java.util.Random;

public class RandomNumberGenerator {
    private static RandomNumberGenerator instance;
    private Random random;

    private RandomNumberGenerator() {
        this.random = new Random();
    }

    public static RandomNumberGenerator getInstance() {
        if(instance == null) {
            instance = new RandomNumberGenerator();
        }

        return instance;
    }

    public int generateRandomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
