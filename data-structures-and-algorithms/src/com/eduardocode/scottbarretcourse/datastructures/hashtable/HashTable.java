package com.eduardocode.scottbarretcourse.datastructures.hashtable;

public class HashTable {

    private int size = 7;
    private Node[] dataMap;

    public HashTable() {
        dataMap = new Node[size];
    }

    public void print() {
        System.out.println("Hash table: ");

        for (int i = 0; i < size; i++) {
            System.out.println(i + ": ");

            Node temp = dataMap[i];
            while(temp != null) {
                System.out.println("{ key: " + temp.key + ", value: " + temp.value + " }");

                temp = temp.next;
            }
        }
    }

    private class Node {

        public String key;
        public int value;
        public Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
