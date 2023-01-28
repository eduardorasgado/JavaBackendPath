package com.eduardocode.scottbarretcourse.datastructures.hashtable;

public class HashTable<T> {

    private int size = 7;
    private final Node<T>[] dataMap;

    public HashTable() {
        dataMap = new Node[size];
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();

        for (int i = 0; i < keyChars.length; i++) {
            hash = (hash + keyChars[i] * 23) % size;
        }

        return hash;
    }

    public void set(String key, T value) {
        int index = hash(key);

        Node<T> newNode = new Node<>(key, value);
        Node<T> currNode = dataMap[index];

        if(currNode != null) {
            currNode.next = newNode;
        }
        else {
            dataMap[index] = newNode;
        }
    }

    public void print() {
        System.out.println("Hash table: ");

        for (int i = 0; i < size; i++) {
            System.out.println(i + ": ");

            Node<T> temp = dataMap[i];
            while(temp != null) {
                System.out.println("{ key: " + temp.key + ", value: " + temp.value + " }");

                temp = temp.next;
            }
        }
    }

    private class Node<NT> {

        public String key;
        public NT value;
        public Node<NT> next;

        public Node(String key, NT value) {
            this.key = key;
            this.value = value;
        }
    }
}
