package com.eduardocode.designpatterns.creational.prototype.simpleinterface;

public interface Prototype<T> extends Cloneable {
    PropertyHolder<T> clone();
}
