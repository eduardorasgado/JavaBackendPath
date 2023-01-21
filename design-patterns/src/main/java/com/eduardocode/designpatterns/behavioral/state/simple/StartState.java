package com.eduardocode.designpatterns.behavioral.state.simple;

public class StartState implements State {

    @Override
    public void doAction() {
        System.out.println("Player is in start state");
    }
}
