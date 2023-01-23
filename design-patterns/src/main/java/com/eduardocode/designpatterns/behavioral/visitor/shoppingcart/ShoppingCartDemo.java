package com.eduardocode.designpatterns.behavioral.visitor.shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDemo {

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Book(20, "12324"));
        items.add(new Book(100, "50602"));
        items.add(new Fruit(8, 3, "Banana"));
        items.add(new Fruit(6, 5, "Apple"));

        int total = new ShoppingCartClient().calculatePrice(items);
        System.out.println("Total cost: " + total);
    }
}
