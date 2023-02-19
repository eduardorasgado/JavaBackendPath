package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.mapexporter;

public interface GeoElement {
    void accept(GeoVisitor visitor);
}
