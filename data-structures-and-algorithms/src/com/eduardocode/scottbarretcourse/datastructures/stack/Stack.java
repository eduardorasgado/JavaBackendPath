package com.eduardocode.scottbarretcourse.datastructures.stack;

public class Stack {
    private Node top;
    private int height;

    public Stack(int value) {
        top = new Node(value);
        ++height;
    }

    public Stack() {}

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        ++height;
    }

    public void printStack() {
        System.out.println("stack: ");
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node getTop() {
        return top;
    }

    public int getHeight() {
        return height;
    }

    class Node {
        int value;
        Node next;

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
