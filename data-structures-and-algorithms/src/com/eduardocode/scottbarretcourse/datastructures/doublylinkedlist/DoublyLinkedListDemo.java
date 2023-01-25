package com.eduardocode.scottbarretcourse.datastructures.doublylinkedlist;

public class DoublyLinkedListDemo {

    public static void main(String[] args) {
        removeFirst();
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
