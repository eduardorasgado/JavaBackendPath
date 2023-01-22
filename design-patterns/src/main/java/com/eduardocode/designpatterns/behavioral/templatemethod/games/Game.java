package com.eduardocode.designpatterns.behavioral.templatemethod.games;

public abstract class Game {

    public void play() {
        waitingForPlayers();
        initialize();
        startPlay();
        endPlay();
    }

    private void waitingForPlayers() {
        System.out.println("All the players joined the game");
    }

    protected abstract void initialize();

    protected abstract void startPlay();

    protected abstract void endPlay();
}
