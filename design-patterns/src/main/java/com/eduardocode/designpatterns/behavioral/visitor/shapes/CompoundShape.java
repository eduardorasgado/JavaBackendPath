package com.eduardocode.designpatterns.behavioral.visitor.shapes;

public class CompoundShape implements Shape {

    private String shapes;

    @Override
    public String getName() {
        return "Compound Shape";
    }

    @Override
    public String accept(ExportVisitor visitor) {
        return visitor.visit(this);
    }

    public String getShapes() {
        return shapes;
    }

    public void setShapes(String shapes) {
        this.shapes = shapes;
    }
}
