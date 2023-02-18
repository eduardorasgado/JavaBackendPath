package com.eduardocode.objectorienteddesign.designpatterns.behavioral.observer.onlinestore;

public class B2BCustomer implements Customer {
    private String name;

    public B2BCustomer(String name) {
        this.name = name;
    }

    @Override
    public void buy(Product product) {
        System.out.println(name + " just bought a Tv by " + product.getPrice());
    }

    @Override
    public void update(Product product) {
        if(product instanceof Tv) {
            buy(product);
        }
    }
}
