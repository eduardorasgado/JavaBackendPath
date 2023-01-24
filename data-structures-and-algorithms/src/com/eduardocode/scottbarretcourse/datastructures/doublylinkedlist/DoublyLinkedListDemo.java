package com.eduardocode.scottbarretcourse.datastructures.doublylinkedlist;

public class DoublyLinkedListDemo {

    public static void main(String[] args) {
        append();
    }

    private static void append() {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.append(1);
        dll.printList();

        dll.append(5);
        dll.printList();

        dll.append(0);
        dll.printList();

        dll.append(7);
        dll.printList();
    }

    private static void create() {
        DoublyLinkedList dll = new DoublyLinkedList(10);
        dll.printList();
    }
}
