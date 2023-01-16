package com.eduardocode.designpatterns.creational.prototype.simpleinterface;

public class ConcretePrototypeA implements PropertyHolder<String> {
    private String property;
    public ConcretePrototypeA(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    @Override
    public PropertyHolder<String> clone() {
        return new ConcretePrototypeA(property);
    }
}
