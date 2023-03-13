package com.eduardocode.objectorienteddesign.designpatterns.behavioral.templatemethod.printer;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Order {
    private final String id;

    private final LocalDate date;

    private final Map<String, Double> items;

    private double total;

    public Order(String id) {
        this.id = id;
        date = LocalDate.now();
         items = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Map<String, Double> getItems() {
        return items;
    }

    public Set<Map.Entry<String, Double>> getItemsAsSet() {
        assert getItems() != null;

        return getItems().entrySet();
    }

    public void addItem(String name, double price) {
        items.put(name, price);
        total+= price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
