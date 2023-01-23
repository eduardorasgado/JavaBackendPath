package com.eduardocode.scottbarretcourse.datastructures.linkedlist;

import java.util.NoSuchElementException;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        tail = head = new Node(value);
        length = 1;
    }

    public LinkedList() {

    }

    public void append(int value) {
        Node newNode = new Node(value);

        if(head == null) {
            tail = head = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        ++length;
    }

    public Node removeLast() {
        if(head == null) {
            return null;
        }
        Node temp = head;

        if(length == 1) {
            empty();
        }
        else {
            Node previousTemp = head;

            while (temp.next != null) {
                previousTemp = temp;
                temp = temp.next;
            }

            tail = previousTemp;
            tail.next = null;

            --length;
        }

        return temp;
    }

    public void prepend(int value) {
        if(head == null) {
            append(value);
        }
        else {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
            ++length;
        }
    }

    public Node removeFirst() {
        if(head == null) {
            return null;
        }
        Node temp = head;
        head = temp.next;
        temp.next = null;
        --length;

        if(head == null) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if(index < 0 || index >= length) {
            return null;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public boolean set(int index, int value) {
        if(index < 0 || (length > 0 && index >= length)) {
            return false;
        }

        if (head == null || length == 1 || index == 0) {
            prepend(value);
        }
        else {
            Node newNode = new Node(value);
            Node temp = head;
            Node prevTemp = head;

            for (int i = 0; i < index; i++) {
                prevTemp = temp;
                temp = temp.next;
            }

            newNode.next = temp;
            prevTemp.next = newNode;

            ++length;
        }

        return true;
    }

    public void printList() {
        System.out.println("Linked list: ");

        Node currNode = getHead();
        while(currNode != null) {
            System.out.println(currNode);
            currNode = currNode.next;
        }
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

    class Node {
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
