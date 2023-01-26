package com.eduardocode.scottbarretcourse.datastructures.queue;

public class Queue {
    private Node first;
    private Node last;
    private int length;

    public Queue() {}

    public Queue(int value) {
        first = last = new Node(value);
        ++length;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);

        if(length == 0) {
            first = last = newNode;
        }
        else {
            last.next = newNode;
            last = newNode;
        }
        ++length;
    }

    public Node dequeue() {
        if(length == 0) {
            return null;
        }

        Node temp = first;
        if(length == 1) {
            first = null;
            last = null;
        }
        else {
            first = first.next;
            temp.next = null;
        }

        --length;
        return temp;
    }

    public void print() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
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
                    ", next=" + next +
                    '}';
        }
    }
}
