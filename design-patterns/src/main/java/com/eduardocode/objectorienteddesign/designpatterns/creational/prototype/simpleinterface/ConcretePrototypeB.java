package com.eduardocode.objectorienteddesign.designpatterns.creational.prototype.simpleinterface;

public class ConcretePrototypeB implements PropertyHolder<Integer> {
    private int property;
    public ConcretePrototypeB(int property) {
        this.property = property;
    }

    public Integer getProperty() {
        return property;
    }

    public void setProperty(Integer property) {
        this.property = property;
    }

    @Override
    public PropertyHolder<Integer> clone() {
        return new ConcretePrototypeB(property);
    }
}
