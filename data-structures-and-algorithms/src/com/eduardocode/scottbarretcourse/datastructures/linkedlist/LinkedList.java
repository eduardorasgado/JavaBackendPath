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
        else {
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
        else {
            Node temp = head;
            head = temp.next;

            if(head == null) {
                empty();
            }
            else {
                --length;
            }
            return temp;
        }
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
