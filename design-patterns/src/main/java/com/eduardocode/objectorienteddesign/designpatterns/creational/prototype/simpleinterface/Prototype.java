package com.eduardocode.objectorienteddesign.designpatterns.creational.prototype.simpleinterface;

public interface Prototype<T> extends Cloneable {
    PropertyHolder<T> clone();
}
