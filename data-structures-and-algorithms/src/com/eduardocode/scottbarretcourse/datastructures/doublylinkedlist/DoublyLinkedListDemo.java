package com.eduardocode.scottbarretcourse.datastructures.doublylinkedlist;

import com.eduardocode.scottbarretcourse.datastructures.linkedlist.LinkedList;

public class DoublyLinkedListDemo {

    public static void main(String[] args) {
        remove();
    }

    public static void remove() {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.append(5);
        dll.append(4);
        dll.append(8);
        dll.append(18);
        dll.append(1);
        dll.printList();

        System.out.println("[1] remove index 0: " + dll.remove(0).value);
        dll.printList();
        System.out.println("[1] remove index 3: " + dll.remove(3).value);
        dll.printList();
        System.out.println("[1] remove index 3: " + dll.remove(3));
        dll.printList();

        System.out.println("[1] remove index 1: " + dll.remove(1).value);
        dll.printList();

        System.out.println();

        DoublyLinkedList dll2 = new DoublyLinkedList();
        dll2.append(15);
        System.out.println("[1] remove index 0: " + dll2.remove(0).value);
        dll2.printList();

        System.out.println("[1] remove index 0: " + dll2.remove(0));
        dll2.printList();
    }

    public static void insert() {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.append(5);
        dll.append(4);
        dll.append(8);
        dll.append(18);
        dll.append(1);
        dll.printList();

        System.out.println("[1] insert value: 3 at index 2: " + dll.insert(2, 3));
        dll.printList();
        System.out.println("[1] insert value: 11 at index 0: " + dll.insert(0, 11));
        dll.printList();
        System.out.println("[1] insert value: 22 at index 6: " + dll.insert(6, 22));
        dll.printList();
        System.out.println("[1] insert value: 100 at index 8: " + dll.insert(8, 100));
        dll.printList();

        System.out.println();

        DoublyLinkedList dll2 = new DoublyLinkedList();
        dll2.append(4);
        dll2.printList();

        System.out.println("[2] insert value: 1 at index 0: " + dll2.insert(0, 1));
        dll2.printList();
        System.out.println("[2] insert value: 10 at index 1: " + dll2.insert(1, 10));
        dll2.printList();

        System.out.println();

        DoublyLinkedList dll3 = new DoublyLinkedList();
        dll3.printList();
        System.out.println("[3] insert value: 99 at index 0: " + dll3.insert(0, 99));
        dll3.printList();
    }

    public static void set() {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.append(5);
        dll.append(4);
        dll.append(8);
        dll.append(18);
        dll.append(1);
        dll.printList();

        System.out.println("[1] set value: 3 at index 2: " + dll.set(2, 3));
        dll.printList();
        System.out.println("[1] set value: 11 at index 0: " + dll.set(0, 11));
        dll.printList();
        System.out.println("[1] set value: 22 at index 4: " + dll.set(4, 22));
        dll.printList();
        System.out.println("[1] set value: 100 at index 8: " + dll.set(8, 100));
        dll.printList();

        System.out.println();

        DoublyLinkedList dll2 = new DoublyLinkedList();
        dll2.append(4);
        dll2.printList();

        System.out.println("[2] set value: 1 at index 0: " + dll2.set(0, 1));
        dll2.printList();
        System.out.println("[2] set value: 10 at index 1: " + dll2.set(1, 10));
        dll2.printList();

        System.out.println();

        DoublyLinkedList linkedList3 = new DoublyLinkedList();
        linkedList3.printList();
        System.out.println("[3] set value: 99 at index 0: " + linkedList3.set(0, 99));
        linkedList3.printList();
    }

    public static void get() {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.append(5);
        dll.append(4);
        dll.append(8);
        dll.append(20);
        dll.append(22);
        dll.append(11);
        dll.append(9);

        System.out.println("[1] getting index 0: " + dll.get(0));
        System.out.println("[1] getting index 2: " + dll.get(2));
        System.out.println("[1] getting index 3: " + dll.get(3));
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
