package com.eduardocode.designpatterns.creational.prototype.simpleinterface;

public class ConcretePrototypeB implements Prototype<Integer> {
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
    public Prototype<Integer> clone() {
        return new ConcretePrototypeB(property);
    }
}
