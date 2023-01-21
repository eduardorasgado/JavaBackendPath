package com.eduardocode.designpatterns.behavioral.state.simpletransition;

public class SimpleTransitionDemo {

    public static void main(String[] args) {
        State initialState = new FirstState();

        ConcreteContext context = new ConcreteContext(initialState);
        context.showInformation();

        context.doThis();
        context.showInformation();

        context.doThat();
        context.showInformation();

        context.doThis();
        context.showInformation();

        context.doThat();
        context.showInformation();

    }
}
