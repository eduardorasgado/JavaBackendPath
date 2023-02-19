package com.eduardocode.objectorienteddesign.designpatterns.behavioral.visitor.mapexporter;

public abstract class ExportVisitor implements GeoVisitor {
    public void export(GeoElement... elements) {
        for(GeoElement element : elements) {
            element.accept(this);
        }
    }

    protected String getClassName() {
        return getClass().getSimpleName();
    }
}
