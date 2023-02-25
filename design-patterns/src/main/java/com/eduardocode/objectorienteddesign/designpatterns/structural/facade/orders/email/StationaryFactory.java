package com.eduardocode.objectorienteddesign.designpatterns.structural.facade.orders.email;

public class StationaryFactory {
    public static Stationary createStationary() {
        return new HalloweenStationary();
    }
}
