package com.eduardocode.scottbarretcourse.datastructures.doublylinkedlist;

import com.eduardocode.scottbarretcourse.datastructures.linkedlist.LinkedList;

public class DoublyLinkedListDemo {

    public static void main(String[] args) {
        get();
    }

    public static void get() {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.append(5);
        dll.append(4);
        dll.append(8);
        dll.append(20);
        dll.append(22);
        dll.append(11);

        System.out.println("[1] getting index 0: " + dll.get(0));
        System.out.println("[1] getting index 2: " + dll.get(2));
        System.out.println("[1] getting index 2: " + dll.get(3));
        System.out.println("[1] getting index 4: " + dll.get(4));
        System.out.println("[1] getting index 5: " + dll.get(5));

        System.out.println("[1] getting index 6: " + dll.get(6));
        System.out.println("[1] getting index -1: " + dll.get(-1));

        LinkedList dll2 = new LinkedList();
        dll2.append(4);
        System.out.println("[2] getting index 0: " + dll2.get(0));
        System.out.println("[2] getting index 1: " + dll2.get(1));

        LinkedList dll3 = new LinkedList();
        System.out.println("[3] getting index 0: " + dll3.get(0));
    }

    private static void removeFirst() {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.append(1);
        dll.append(5);
        dll.append(0);
        dll.append(7);
        dll.printList();

        System.out.println("removing first: " + dll.removeFirst().value);
        dll.printList();
        System.out.println("removing first: " + dll.removeFirst().value);
        dll.printList();
        System.out.println("removing first: " + dll.removeFirst().value);
        dll.printList();
        System.out.println("removing first: " + dll.removeFirst().value);
        dll.printList();
        System.out.println("removing first: " + dll.removeFirst());
        dll.printList();
    }

    private static void prepend() {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.prepend(1);
        dll.printList();
        dll.prepend(5);
        dll.printList();
        dll.prepend(0);
        dll.printList();
        dll.prepend(7);
        dll.printList();

        dll.append(4);
        dll.printList();
    }

    private static void removeLast() {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.append(1);
        dll.append(5);
        dll.append(0);
        dll.append(7);
        dll.printList();
        System.out.println("Last removed: " + dll.removeLast().value);
        dll.printList();
        System.out.println("Last removed: " + dll.removeLast().value);
        dll.printList();
        System.out.println("Last removed: " + dll.removeLast().value);
        dll.printList();
        System.out.println("Last removed: " + dll.removeLast().value);
        dll.printList();

        System.out.println("Last removed: " + dll.removeLast());
        dll.printList();

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
