package com.eduardocode.designpatterns.behavioral.visitor.shoppingcart;

public interface Item {

    int accept(ShoppingCartVisitor visitor);
}
