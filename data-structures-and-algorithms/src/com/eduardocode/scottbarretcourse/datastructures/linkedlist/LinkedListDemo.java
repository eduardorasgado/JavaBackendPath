package com.eduardocode.scottbarretcourse.datastructures.linkedlist;

public class LinkedListDemo {

    public static void main(String[] args) {
        remove();
    }

    public static void remove() {
        LinkedList linkedList = new LinkedList();

        linkedList.append(5);
        linkedList.append(4);
        linkedList.append(8);
        linkedList.append(18);
        linkedList.append(1);
        linkedList.printList();

        System.out.println("[1] remove index 0: " + linkedList.remove(0).value);
        linkedList.printList();
        System.out.println("[1] remove index 3: " + linkedList.remove(3).value);
        linkedList.printList();
        System.out.println("[1] remove index 3: " + linkedList.remove(3));
        linkedList.printList();

        System.out.println("[1] remove index 1: " + linkedList.remove(1).value);
        linkedList.printList();

        System.out.println();

        LinkedList linkedList2 = new LinkedList();
        linkedList2.append(15);
        System.out.println("[1] remove index 0: " + linkedList2.remove(0).value);
        linkedList2.printList();

        System.out.println("[1] remove index 0: " + linkedList2.remove(0));
        linkedList2.printList();
    }

    public static void insert() {
        LinkedList linkedList = new LinkedList();

        linkedList.append(5);
        linkedList.append(4);
        linkedList.append(8);
        linkedList.append(18);
        linkedList.append(1);
        linkedList.printList();

        System.out.println("[1] set value: 3 at index 2: " + linkedList.insert(2, 3));
        linkedList.printList();
        System.out.println("[1] set value: 11 at index 0: " + linkedList.insert(0, 11));
        linkedList.printList();
        System.out.println("[1] set value: 22 at index 6: " + linkedList.insert(6, 22));
        linkedList.printList();
        System.out.println("[1] set value: 100 at index 8: " + linkedList.insert(8, 100));
        linkedList.printList();

        System.out.println();

        LinkedList linkedList2 = new LinkedList();
        linkedList2.append(4);
        linkedList2.printList();

        System.out.println("[2] set value: 1 at index 0: " + linkedList2.insert(0, 1));
        linkedList2.printList();
        System.out.println("[2] set value: 10 at index 1: " + linkedList2.insert(1, 10));
        linkedList2.printList();

        System.out.println();

        LinkedList linkedList3 = new LinkedList();
        linkedList3.printList();
        System.out.println("[3] set value: 99 at index 0: " + linkedList3.insert(0, 99));
        linkedList3.printList();
    }

    public static void set() {
        LinkedList linkedList = new LinkedList();

        linkedList.append(5);
        linkedList.append(4);
        linkedList.append(8);
        linkedList.append(18);
        linkedList.append(1);
        linkedList.printList();

        System.out.println("[1] set value: 3 at index 2: " + linkedList.set(2, 3));
        linkedList.printList();
        System.out.println("[1] set value: 11 at index 0: " + linkedList.set(0, 11));
        linkedList.printList();
        System.out.println("[1] set value: 22 at index 4: " + linkedList.set(4, 22));
        linkedList.printList();
        System.out.println("[1] set value: 100 at index 8: " + linkedList.set(8, 100));
        linkedList.printList();

        System.out.println();

        LinkedList linkedList2 = new LinkedList();
        linkedList2.append(4);
        linkedList2.printList();

        System.out.println("[2] set value: 1 at index 0: " + linkedList2.set(0, 1));
        linkedList2.printList();
        System.out.println("[2] set value: 10 at index 1: " + linkedList2.set(1, 10));
        linkedList2.printList();

        System.out.println();

        LinkedList linkedList3 = new LinkedList();
        linkedList3.printList();
        System.out.println("[3] set value: 99 at index 0: " + linkedList3.set(0, 99));
        linkedList3.printList();
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

        System.out.println("[1] getting index 6: " + linkedList.get(6));
        System.out.println("[1] getting index -1: " + linkedList.get(-1));

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
