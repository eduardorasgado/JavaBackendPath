package com.eduardocode.designpatterns.structural.decorator.pizza;

public class Margherita implements Pizza {

    @Override
    public String getDescription() {
        return "Margherita";
    }

    @Override
    public double getPrice() {
        return 7.99;
    }
}
