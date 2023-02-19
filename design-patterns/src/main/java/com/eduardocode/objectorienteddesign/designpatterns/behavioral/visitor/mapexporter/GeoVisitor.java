package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.mapexporter;

public interface GeoVisitor {

    void visit(Park park);

    void visit(ShoppingCenter shoppingCenter);

    void visit(PrivateBuilding privateBuilding);

    void visit(IndustrialBuilding industrialBuilding);
}
