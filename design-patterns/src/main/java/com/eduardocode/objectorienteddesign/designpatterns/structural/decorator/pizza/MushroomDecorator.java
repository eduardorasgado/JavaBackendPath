package com.eduardocode.objectorienteddesign.designpatterns.structural.decorator.pizza;

public class MushroomDecorator extends PizzaDecorator {
    public MushroomDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Mushroom";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 2.00;
    }
}
