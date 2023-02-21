package com.eduardocode.objectorienteddesign.designpatterns.structural.bridge.datastructure;

// Abstraction
public interface FifoCollection<T> {

    //Adds element to collection
    void offer(T element);

    //Removes & returns first element from collection
    T poll();
}
