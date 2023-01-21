package com.eduardocode.designpatterns.behavioral.state.simpletransition;

public class FinalState extends BaseState {

    public FinalState() {
        super("Third State");
    }

    @Override
    public void doThis() {
        System.out.println("Final State is doing this");
    }

    @Override
    public void doThat() {
        System.out.println("Final State is doing that");
    }
}
