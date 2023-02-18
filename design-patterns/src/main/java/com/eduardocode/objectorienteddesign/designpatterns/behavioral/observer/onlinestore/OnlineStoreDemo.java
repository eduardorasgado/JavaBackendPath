package com.eduardocode.objectorienteddesign.designpatterns.behavioral.observer.onlinestore;

public class OnlineStoreDemo {

    public static void main(String[] args) {
        OnlineStore store = new OnlineStore();

        B2CCustomer customer1 = new B2CCustomer("Another Store");
        B2BCustomer customer2 = new B2BCustomer("B2B Electronics Provider");
        B2CCustomer customer3 = new B2CCustomer("A retail store in Mexico");

        store.subscribe(customer1);
        store.subscribe(customer2);
        store.subscribe(customer3);

        store.registerArrival(new Tv());
        System.out.println();
        store.registerArrival(new Drone());

        System.out.println();
        store.unsubscribe(customer1);

        store.registerArrival(new Drone());
    }
}
