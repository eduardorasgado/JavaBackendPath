package com.eduardocode.scottbarretcourse.datastructures.queue;

public class Queue {
    private Node first;
    private Node last;
    private int length;

    public void enque(int value) {
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
        return null;
    }

    public void print() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
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
