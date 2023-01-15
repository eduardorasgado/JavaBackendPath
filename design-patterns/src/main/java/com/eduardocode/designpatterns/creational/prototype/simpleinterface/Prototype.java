package com.eduardocode.designpatterns.creational.prototype.simpleinterface;

public interface Prototype<T> extends Cloneable{
    T getProperty();

    void setProperty(T t);
    Prototype<T> clone();
}
