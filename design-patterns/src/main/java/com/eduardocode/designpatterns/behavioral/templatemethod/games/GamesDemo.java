package com.eduardocode.designpatterns.behavioral.templatemethod.games;

public class GamesDemo {

    public static void main(String[] args) {
        Game game = new Chess();
        game.play();

        game = new Football();
        game.play();
    }
}
