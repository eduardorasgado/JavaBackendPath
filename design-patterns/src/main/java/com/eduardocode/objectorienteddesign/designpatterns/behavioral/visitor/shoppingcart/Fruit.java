package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.shoppingcart;

public class Fruit implements Item {
    private int pricePerKg;
    private int weightInKg;
    private String name;

    public Fruit(int pricePerKg, int weightInKg, String name) {
        this.pricePerKg = pricePerKg;
        this.weightInKg = weightInKg;
        this.name = name;
    }

    public int getPricePerKg() {
        return pricePerKg;
    }

    public int getWeightInKg() {
        return weightInKg;
    }

    public String getName() {
        return name;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}
