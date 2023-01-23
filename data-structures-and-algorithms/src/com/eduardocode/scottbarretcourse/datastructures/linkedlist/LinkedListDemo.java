package com.eduardocode.scottbarretcourse.datastructures.linkedlist;

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(5);

        System.out.println(linkedList.getHead());
        System.out.println(linkedList.getTail());
        System.out.println(linkedList.getLength());

        linkedList.printList();

    }
}
