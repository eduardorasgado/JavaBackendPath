package com.eduardocode.designpatterns.behavioral.visitor.shoppingcart;

public interface ShoppingCartVisitor {
    int visit(Book book);

    int visit(Fruit fruit);
}
