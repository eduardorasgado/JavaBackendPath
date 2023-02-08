package com.eduardocode.objectorienteddesign.designpatterns.creational.prototype.shapes;

public class Shape implements Prototype {
    private String id;
    private String type;

    public Shape(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Prototype clone() {
        return new Shape(id, type);
    }
}
