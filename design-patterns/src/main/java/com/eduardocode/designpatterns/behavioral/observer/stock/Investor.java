package com.eduardocode.designpatterns.behavioral.observer.stock;

import java.util.ArrayList;
import java.util.List;

public class Investor implements Observer {
    private String name;
    private List<Stock> stockList;

    public Investor(String name) {
        this.name = name;
        stockList = new ArrayList<>();
    }

    @Override
    public void update(Stock stock) {
        if(stockList.contains(stock)) {
            System.out.println(name + ": The price of " + stock.getSymbol() + " has changed to " + stock.getPrice());
        }
    }

    public void addStock(Stock stock) {
        if(!stockList.contains(stock)) {
            stockList.add(stock);
            stock.subscribe(this);
        }
    }

    public void removeStock(Stock stock) {
        if(stockList.remove(stock)) {
            stock.unsubscribe(this);
        }
    }
}
