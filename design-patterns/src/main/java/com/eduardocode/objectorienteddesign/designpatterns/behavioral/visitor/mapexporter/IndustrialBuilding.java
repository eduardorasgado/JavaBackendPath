package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.mapexporter;

public class IndustrialBuilding implements GeoElement {

    // internal behavior and data related to geolocation and industrial building specific business

    @Override
    public void accept(GeoVisitor visitor) {
        visitor.visit(this);
    }
}
