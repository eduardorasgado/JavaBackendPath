package com.eduardocode.objectorienteddesign.designpatterns.structural.decorator.simple;

public class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component wrappedComponent) {
        super(wrappedComponent);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("Concrete Decorator A operation");
    }
}
