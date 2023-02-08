package com.eduardocode.objectorienteddesign.designpatterns.structural.decorator.pizza;

public abstract class PizzaDecorator implements Pizza {
    private Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getPrice() {
        return pizza.getPrice();
    }
}
