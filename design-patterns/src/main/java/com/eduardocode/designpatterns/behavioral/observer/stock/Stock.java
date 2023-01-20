package com.eduardocode.designpatterns.behavioral.observer.stock;

import java.util.ArrayList;
import java.util.List;

public class Stock implements Subject {
    private String symbol;
    private int price;
    private List<Observer> subscribers;

    public Stock(String symbol, int price) {
        this.symbol = symbol;
        this.price = price;

        subscribers = new ArrayList<>();
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
        notifyObservers();
    }

    @Override
    public void subscribe(Observer observer) {
        if(!subscribers.contains(observer)) {
            subscribers.add(observer);
        }
    }

    @Override
    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer subscriber : subscribers) {
            subscriber.update(this);
        }
    }
}
