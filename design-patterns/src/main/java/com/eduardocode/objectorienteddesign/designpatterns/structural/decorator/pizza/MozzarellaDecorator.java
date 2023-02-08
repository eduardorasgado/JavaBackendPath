package com.eduardocode.objectorienteddesign.designpatterns.structural.decorator.pizza;

public class MozzarellaDecorator extends PizzaDecorator {

    public MozzarellaDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Mozzarella";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 1.50;
    }
}
