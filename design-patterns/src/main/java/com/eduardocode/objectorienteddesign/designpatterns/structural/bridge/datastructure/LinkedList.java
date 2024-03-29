package com.eduardocode.objectorienteddesign.designpatterns.structural.bridge.datastructure;

// implementor
public interface LinkedList<T> {

    void addFirst(T element);

    T removeFirst();

    void addLast(T element);

    T removeLast();

    int getSize();
}
