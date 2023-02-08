package com.eduardocode.objectorienteddesign.designpatterns.behavioral.iterator.namerepository;

public interface Container {
    Iterator getIterator();

    void add(Object item);
}
