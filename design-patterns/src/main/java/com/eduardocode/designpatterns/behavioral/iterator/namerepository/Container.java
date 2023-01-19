package com.eduardocode.designpatterns.behavioral.iterator.namerepository;

public interface Container {
    Iterator getIterator();

    void add(Object item);
}
