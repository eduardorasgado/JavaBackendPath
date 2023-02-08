package com.eduardocode.objectorienteddesign.designpatterns.behavioral.templatemethod.games;

public class Chess extends Game {

    @Override
    protected void initialize() {
        System.out.println("Chess Game initialized. Ready to play");
    }

    @Override
    protected void startPlay() {
        System.out.println("Chess game Started. Enjoy the game!");
    }

    @Override
    protected void endPlay() {
        System.out.println("Chess game Finished.");
    }
}
