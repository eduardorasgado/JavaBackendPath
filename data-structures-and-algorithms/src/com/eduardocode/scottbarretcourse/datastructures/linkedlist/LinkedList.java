package com.eduardocode.scottbarretcourse.datastructures.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        tail = head = new Node(value);
        length = 1;
    }

    public void printList() {
        System.out.println("Linked list: ");

        Node currNode = getHead();
        while(currNode != null) {
            System.out.println(currNode);
            currNode = currNode.next;
        }
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    private class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
