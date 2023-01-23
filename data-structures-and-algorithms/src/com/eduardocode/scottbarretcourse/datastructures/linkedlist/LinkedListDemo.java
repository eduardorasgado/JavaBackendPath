package com.eduardocode.scottbarretcourse.datastructures.linkedlist;

public class LinkedListDemo {

    public static void main(String[] args) {
        get();
    }

    public static void get() {
        LinkedList linkedList = new LinkedList();

        linkedList.append(5);
        linkedList.append(4);
        linkedList.append(8);
        linkedList.append(20);
        linkedList.append(22);

        System.out.println("[1] getting index 0: " + linkedList.get(0));
        System.out.println("[1] getting index 2: " + linkedList.get(2));
        System.out.println("[1] getting index 4: " + linkedList.get(4));

        LinkedList linkedList2 = new LinkedList();
        linkedList2.append(4);
        System.out.println("[2] getting index 0: " + linkedList2.get(0));
        System.out.println("[2] getting index 1: " + linkedList2.get(1));

        LinkedList linkedList3 = new LinkedList();
        System.out.println("[3] getting index 0: " + linkedList3.get(0));
    }


    public static void removeFirst() {
        LinkedList linkedList = new LinkedList();

        linkedList.append(5);
        linkedList.append(4);
        linkedList.append(8);

        LinkedList.Node removedNode = linkedList.removeFirst();
        System.out.println("First removed: " + removedNode.value);
        System.out.println("removed node next ref: " + removedNode.next); //checking if removed node still has a reference to next node

        linkedList.printList();
        System.out.println("First removed: " + linkedList.removeFirst().value);
        linkedList.printList();
        System.out.println("First removed: " + linkedList.removeFirst().value);
        linkedList.printList();
        System.out.println("First removed: " + linkedList.removeFirst());
        linkedList.printList();

        linkedList.append(0);
        linkedList.append(1);
        linkedList.printList();
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

    public static void appendAndRemovingLast() {
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
