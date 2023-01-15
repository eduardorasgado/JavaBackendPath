package com.eduardocode.designpatterns.creational.builder.inner.pizza;

public class PizzaDemo {

    public static void main(String[] args) {
        Pizza myPizza = new Pizza.Builder()
                .dough("Thin Crust")
                .sauce("Marinara")
                .topping("Mozzarella")
                .topping("Parmesan")
                .topping("Mushrooms")
                .build();

        System.out.println(myPizza.getIngredients());
    }
}
