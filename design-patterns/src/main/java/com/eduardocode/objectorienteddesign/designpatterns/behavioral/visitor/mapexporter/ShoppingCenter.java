package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.mapexporter;

public class ShoppingCenter implements GeoElement {

    // internal behavior and data related to geolocation and shopping center specific business

    @Override
    public void accept(GeoVisitor visitor) {
        visitor.visit(this);
    }
}
