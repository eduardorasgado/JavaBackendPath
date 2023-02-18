package com.eduardocode.objectorienteddesign.designpatterns.behavioral.observer.onlinestore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OnlineStore {
    private Set<Customer> customers;
    private List<Product> stock;

    public OnlineStore() {
        customers = new HashSet<>();
        stock = new ArrayList<>();
    }

    public void subscribe(Customer customer) {
        customers.add(customer);
    }

    public void unsubscribe(Customer customer) {
        customers.remove(customer);
    }

    public void registerArrival(Product product) {
        System.out.println("A new product has arrived to the store");

        stock.add(product);
        notifyCustomers(product);
    }

    private void notifyCustomers(Product product) {
        System.out.println("Notifying customers: ");

        for(Customer customer : customers) {
            customer.update(product);
        }
    }
}
