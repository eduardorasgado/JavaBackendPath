package com.eduardocode.designpatterns.behavioral.templatemethod.games;

public class Football extends Game {

    @Override
    protected void initialize() {
        System.out.println("Football Game initialized. Ready to play");
    }

    @Override
    protected void startPlay() {
        System.out.println("Football Game started. Enjoy the game!");
    }

    @Override
    protected void endPlay() {
        System.out.println("Football Game finished.");
    }
}
