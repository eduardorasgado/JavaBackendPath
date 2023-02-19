package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.mapexporter;

public class PrivateBuilding implements GeoElement {

    // internal behavior and data related to geolocation and private building specific business

    @Override
    public void accept(GeoVisitor visitor) {
        visitor.visit(this);
    }
}
