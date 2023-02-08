package com.eduardocode.objectorienteddesign.designpatterns.structural.decorator.simple;

public class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component wrappedComponent) {
        super(wrappedComponent);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("Concrete Decorator B operation");
    }
}
