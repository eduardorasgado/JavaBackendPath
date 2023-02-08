package com.eduardocode.objectorienteddesign.designpatterns.behavioral.state.simple;

public class StopState implements State {

    @Override
    public void doAction() {
        System.out.println("Player is in stop state");
    }
}
