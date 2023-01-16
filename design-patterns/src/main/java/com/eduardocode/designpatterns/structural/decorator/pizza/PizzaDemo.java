package com.eduardocode.designpatterns.structural.decorator.pizza;

public class PizzaDemo {

    public static void main(String[] args) {
        Pizza pizza = new Margherita();
        System.out.println(pizza.getDescription() + ": " + pizza.getPrice());

        pizza = new MozzarellaDecorator(pizza);
        System.out.println(pizza.getDescription() + ": " + pizza.getPrice());

        pizza = new MushroomDecorator(pizza);
        System.out.println(pizza.getDescription() + ": " + pizza.getPrice());
    }
}
