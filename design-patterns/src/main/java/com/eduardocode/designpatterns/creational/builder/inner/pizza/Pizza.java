package com.eduardocode.designpatterns.creational.builder.inner.pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String dough;
    private String sauce;
    private List<String> toppings;

    private Pizza(Builder builder) {
        this.dough = builder.dough;
        this.sauce = builder.sauce;
        this.toppings = builder.toppings;
    }

    public static class Builder {
        private String dough;
        private String sauce;
        private List<String> toppings= new ArrayList<>();

        public Builder dough(String dough) {
            this.dough = dough;
            return this;
        }

        public Builder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public Builder topping(String topping) {
            if(!toppings.contains(topping)) {
                toppings.add(topping);
            }
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    public String getIngredients() {
        return String.format("Pizza ingredients: dough> %s, sauce> %s, toppings: %s",
                getDough(), getSauce(), String.join(", ", getToppings()));
    }

    private String getDough() {
        return dough;
    }

    private String getSauce() {
        return sauce;
    }

    private List<String> getToppings() {
        return toppings;
    }
}
