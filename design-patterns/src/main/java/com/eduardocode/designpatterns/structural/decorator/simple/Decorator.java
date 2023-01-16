package com.eduardocode.designpatterns.structural.decorator.simple;

public abstract class Decorator implements Component {
    // also called as wrappee
    private final Component wrappedComponent;

    public Decorator(Component wrappedComponent) {
        this.wrappedComponent = wrappedComponent;
    }

    @Override
    public void operation() {
        wrappedComponent.operation();
    }
}
