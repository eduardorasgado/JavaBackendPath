package com.eduardocode.designpatterns.structural.decorator.simple;

public class SimpleDemo {

    public static void main(String[] args) {
        Component component = new ConcreteComponent();

        component = new ConcreteDecoratorA(component);
        component = new ConcreteDecoratorB(component);

        component.operation();
    }
}
