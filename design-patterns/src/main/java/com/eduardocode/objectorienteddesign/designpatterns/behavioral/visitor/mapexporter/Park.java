package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.mapexporter;

public class Park implements GeoElement {

    // internal behavior and data related to geolocation and park specific business

    @Override
    public void accept(GeoVisitor visitor) {
        visitor.visit(this);
    }
}
