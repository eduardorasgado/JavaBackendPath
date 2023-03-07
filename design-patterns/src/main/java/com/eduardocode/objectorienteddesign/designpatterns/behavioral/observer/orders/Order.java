package com.eduardocode.objectorienteddesign.designpatterns.behavioral.observer.orders;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final String id;

    private double shippingCost;

    private double itemCost;

    private double discount;
    //no of items
    private int count;

    private final List<OrderObserver> observers;

    public Order(String id) {
        this.id = id;
        observers = new ArrayList<>();
    }

    public void attach(OrderObserver observer) {
        if(!getObservers().contains(observer)) {
            getObservers().add(observer);
        }
    }

    public void dettach(OrderObserver observer) {
        getObservers().remove(observer);
    }

    public double getTotal() {
        return getItemCost() - getDiscount() + getShippingCost();
    }

    public void addItem(double price) {
        itemCost += price;
        count ++;

        observers.forEach(observer -> observer.update(this));
    }

    public int getCount() {
        return count;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double cost) {
        this.shippingCost = cost;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getItemCost() {
        return itemCost;
    }

    private List<OrderObserver> getObservers() {
        return observers;
    }

    @Override
    public String toString() {

        return "Order#"+id+"\nItem cost:"+itemCost+"\nNo. of items:"+count
                +"\nShipping cost:"+shippingCost+"\nDiscount:"+discount
                +"\nTotal:"+getTotal();
    }
}
