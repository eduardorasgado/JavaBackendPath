package com.eduardocode.objectorienteddesign.designpatterns.structural.bridge.datastructure;

public class DataStructureDemo {

    public static void main(String[] args) {
        FifoCollection<String> fifo = new Queue<>(new SinglyLinkedList<>());
        fifo.offer("First");
        fifo.offer("Second");
        fifo.offer("Third");

        System.out.println(fifo.poll());
        System.out.println(fifo.poll());
    }
}
