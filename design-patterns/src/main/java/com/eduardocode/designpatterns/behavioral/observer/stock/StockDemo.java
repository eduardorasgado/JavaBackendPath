package com.eduardocode.designpatterns.behavioral.observer.stock;

public class StockDemo {

    public static void main(String[] args) {
        Stock google = new Stock("GOOGL", 1000);
        Stock amazon = new Stock("AMZN", 1500);
        Stock facebook = new Stock("FB", 800);

        Investor investor1 = new Investor("Investor 1");
        investor1.addStock(google);
        investor1.addStock(facebook);

        Investor investor2 = new Investor("Investor 2");
        investor2.addStock(google);
        investor2.addStock(amazon);

        google.setPrice(950);
        amazon.setPrice(2000);
        facebook.setPrice(850);

        investor2.removeStock(google);

        google.setPrice(1000);
    }
}
