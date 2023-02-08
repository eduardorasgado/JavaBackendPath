package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.shoppingcart;

public interface Item {

    int accept(ShoppingCartVisitor visitor);
}
