package com.eduardocode.scottbarretcourse.datastructures.doublylinkedlist;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = tail = newNode;
        ++length;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if(head == null){
            head = tail = newNode;
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

        ++length;
    }

    public Node removeLast() {
        if(head == null) {
            return null;
        }
        Node toRemove = tail;
        if(length == 1) {
            empty();
        }
        else {
            tail = toRemove.prev;

            tail.next = null;
            toRemove.prev = null;

            --length;
        }

        return toRemove;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        ++length;
    }

    public void empty() {
        head = null;
        tail = null;
        length = 0;
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

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    class Node {
        public int value;
        public Node next;
        public Node prev;

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
