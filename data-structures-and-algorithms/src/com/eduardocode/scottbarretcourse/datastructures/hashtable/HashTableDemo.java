package com.eduardocode.scottbarretcourse.datastructures.hashtable;

public class HashTableDemo {
    private static HashTable<Integer> ht = new HashTable<>();
    public static void main(String[] args) {
        set();
    }

    private static void setStringHashTable() {
        HashTable<String> hts = new HashTable<>();

        hts.set("hello", "happiness");
        hts.set("hallo", "sadness");
        hts.set("my", "gaming");
        hts.set("thy", "delivering");
        hts.set("m", "java is great");
        hts.set("class", "this is a value");
        hts.set("java", "another value");

        hts.print();
    }

    private static void set() {
        ht.set("nails", 1000);
        ht.set("nuts", 1999);
        ht.set("bolts", 4500);
        ht.set("welder", 45);
        ht.set("iron", 1111);
        ht.set("eduardo", 1200);
        ht.set("hat", 0);
        ht.set("hello", 1);
        ht.set("hallo", 2);
        ht.set("my", 3);
        ht.set("thy", 4);
        ht.set("m", 5);
        ht.set("class", 6);
        ht.set("java", 7);

        ht.print();
    }

    private static void hashMethod() {
//        System.out.println(ht.hash("hello"));
//        System.out.println(ht.hash("hallo"));
//        System.out.println(ht.hash("my"));
//        System.out.println(ht.hash("thy"));
//        System.out.println(ht.hash("m"));
//        System.out.println(ht.hash("class"));
//        System.out.println(ht.hash("java"));
    }

    private static void constructor() {
        ht.print();
    }

}
