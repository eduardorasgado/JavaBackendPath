package com.eduardocode.scottbarretcourse.datastructures.linkedlist;

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

//        System.out.println(linkedList.getHead());
//        System.out.println(linkedList.getTail());
//        System.out.println(linkedList.getLength());

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
}
