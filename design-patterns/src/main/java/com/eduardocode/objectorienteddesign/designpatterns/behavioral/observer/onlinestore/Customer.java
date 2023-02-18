package com.eduardocode.objectorienteddesign.designpatterns.behavioral.observer.onlinestore;

public interface Customer extends Notifiable {
    void buy(Product product);
}
