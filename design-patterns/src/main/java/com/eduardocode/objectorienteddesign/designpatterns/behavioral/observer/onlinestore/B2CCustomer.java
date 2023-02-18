package com.eduardocode.objectorienteddesign.designpatterns.behavioral.observer.onlinestore;

public class B2CCustomer implements Customer {
    private String name;

    public B2CCustomer(String name) {
        this.name = name;
    }

    @Override
    public void buy(Product product) {
        System.out.println(name + " just bought a Drone by " + product.getPrice());
    }

    @Override
    public void update(Product product) {
        if(product instanceof Drone) {
            buy(product);
        }
    }
}
