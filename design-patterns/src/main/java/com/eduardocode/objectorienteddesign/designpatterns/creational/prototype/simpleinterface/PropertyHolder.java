package com.eduardocode.objectorienteddesign.designpatterns.creational.prototype.simpleinterface;

public interface PropertyHolder<T> extends Prototype<T>{
    T getProperty();

    void setProperty(T t);
}
