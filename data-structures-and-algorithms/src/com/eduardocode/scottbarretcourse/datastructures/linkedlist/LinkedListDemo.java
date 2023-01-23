package com.eduardocode.scottbarretcourse.datastructures.linkedlist;

public class LinkedListDemo {

    public static void main(String[] args) {
        prepend();
    }

    public static void prepend() {
        LinkedList linkedList = new LinkedList();

        linkedList.append(5);
        linkedList.append(4);
        linkedList.append(8);
        linkedList.append(0);
        linkedList.printList();

        linkedList.prepend(10);
        linkedList.printList();

        System.out.println("Last removed: " + linkedList.removeLast().value);
        linkedList.printList();

        linkedList.prepend(15);
        linkedList.printList();

        System.out.println("new--------");

        LinkedList linkedList2 = new LinkedList();
        linkedList2.prepend(30);
        linkedList2.append(20);
        linkedList2.prepend(10);
        linkedList2.printList();
    }

    public static void appendAndRemoving() {
        LinkedList linkedList = new LinkedList();

        linkedList.append(5);
        linkedList.append(4);
        linkedList.append(8);
        linkedList.append(0);

        linkedList.printList();
        System.out.println("Last removed: " + linkedList.removeLast().value);
        linkedList.printList();
        System.out.println("Last removed: " + linkedList.removeLast().value);
        linkedList.printList();
        System.out.println("Last removed: " + linkedList.removeLast().value);
        linkedList.printList();

        LinkedList.Node node = linkedList.removeLast();
        System.out.println("Last removed: " + node.value);
        linkedList.printList();

        System.out.println("Last removed: " + linkedList.removeLast());
        linkedList.printList();

        System.out.println();
        linkedList.append(2);
        linkedList.append(6);
        linkedList.append(8);
        linkedList.printList();
    }

    public static void gettingStarted() {
        LinkedList linkedList = new LinkedList(5);
        System.out.println(linkedList.getHead());
        System.out.println(linkedList.getTail());
        System.out.println(linkedList.getLength());
    }
}
