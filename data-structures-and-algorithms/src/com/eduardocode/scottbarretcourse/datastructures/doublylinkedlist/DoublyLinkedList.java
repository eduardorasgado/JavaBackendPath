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

    public Node removeFirst() {
        if(head == null) {
            return null;
        }

        Node toRemove = head;
        if(length == 1) {
            empty();
        } else {
            head = toRemove.next;
            head.prev = null;
            toRemove.next = null;

            --length;
        }

        return toRemove;
    }

    public Node get(int index) {
        if(index < 0 || index >= length) {
            return null;
        }

        Node temp;
        if(index < length / 2) {
            temp = head;

            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        }
        else {
            temp = tail;

            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }

        return  temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);

        if(temp == null) {
            return false;
        }

        temp.value = value;
        return true;
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
