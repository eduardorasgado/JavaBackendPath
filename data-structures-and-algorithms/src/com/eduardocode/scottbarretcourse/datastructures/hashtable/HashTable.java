package com.eduardocode.scottbarretcourse.datastructures.hashtable;

public class HashTable<T> {

    // prime number to size attribute since it helps to reduce
    // the chance to get a collision at set method.
    private int size = 7;
    private final Node<T>[] dataMap;

    public HashTable() {
        dataMap = new Node[size];
    }

    /*
    * multiplying every key chair ascii value by 23
    * and then dividing by size. Both are prime numbers
    * and this is not coincidence, prime numbers will help
    * to reduce collisions on assigning every key value pair
    * to specific slot in the Node array.
     */
    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();

        for (int i = 0; i < keyChars.length; i++) {
            hash = (hash + keyChars[i] * 23) % size;
        }

        return hash;
    }

    /*
    * I am using chaining method to resolve key collisions
    * by storing the key value pair in a linked list for every
    * space in the Node array
     */
    public void set(String key, T value) {
        int index = hash(key);

        Node<T> newNode = new Node<>(key, value);

        if(dataMap[index] == null) {
            dataMap[index] = newNode;
        }
        else {
            Node<T> temp = dataMap[index];
            boolean nodeExists = false;

            while(true) {
                if(temp.key.equals(key)) {
                    temp.value = value;
                    nodeExists = true;
                }

                if(temp.next == null || nodeExists) {
                    break;
                }

                temp = temp.next;
            }

            if(!nodeExists) {
                temp.next = newNode;
            }
        }
    }

    public T get(String key) {
        int index = hash(key);

        T toReturn = null;
        if(dataMap[index] != null) {
            Node<T> temp = dataMap[index];

            while (temp != null) {
                if(temp.key.equals(key)) {
                    toReturn = temp.value;
                    break;
                }
                temp = temp.next;
            }
        }
        return toReturn;
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
