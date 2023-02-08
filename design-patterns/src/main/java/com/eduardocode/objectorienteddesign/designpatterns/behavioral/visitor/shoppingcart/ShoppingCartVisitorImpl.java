package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.shoppingcart;

public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

    @Override
    public int visit(Book book) {
        int cost;
        if(book.getPrice() > 50) {
            cost = book.getPrice() - 5;
        } else {
            cost = book.getPrice();
        }

        System.out.println("Book ISBN: " + book.getIsbn() + " cost: " + cost);
        return cost;
    }

    @Override
    public int visit(Fruit fruit) {
        int cost = fruit.getPricePerKg() * fruit.getWeightInKg();
        System.out.println(fruit.getWeightInKg() + " kg of " + fruit.getName() + " cost: " + cost);
        return cost;
    }
}
