package com.eduardocode.designpatterns.behavioral.visitor.shoppingcart;

import java.util.List;

public class ShoppingCartClient {

    public int calculatePrice(List<Item> items) {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();

        int sum = 0;
        for (Item item : items) {
            sum = sum + item.accept(visitor);
        }

        return sum;
    }
}
