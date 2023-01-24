package com.eduardocode.scottbarretcourse.datastructures.doublylinkedlist;

public class DoublyLinkedListDemo {

    public static void main(String[] args) {
        create();
    }

    private static void create() {
        DoublyLinkedList dll = new DoublyLinkedList(10);
        dll.printList();
    }
}
