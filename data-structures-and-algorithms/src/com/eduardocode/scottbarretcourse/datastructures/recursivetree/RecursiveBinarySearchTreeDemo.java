package com.eduardocode.scottbarretcourse.datastructures.recursivetree;

public class RecursiveBinarySearchTreeDemo {

    private static BinarySearchTree tree;

    public static void main(String[] args) {
        constructor();
        tree.contains(5);
        //insert();
        //contains();
    }

    private static void contains() {
        System.out.println("Contains 5: " + tree.contains(5));
        System.out.println("Contains 34: " + tree.contains(34));
        System.out.println("Contains 1: " + tree.contains(1));
        System.out.println("Contains 2: " + tree.contains(2));
        System.out.println("Contains 50: " + tree.contains(50));
        System.out.println("Contains 77: " + tree.contains(77));
        System.out.println("Contains 61: " + tree.contains(61));
    }

    private static void insert() {

        System.out.println("inserting 50: " + tree.insert(50));
        System.out.println("inserting 50: " + tree.insert(30));
        System.out.println("inserting 70: " + tree.insert(70));
        System.out.println("inserting 34: " + tree.insert(34));
        System.out.println("inserting 4: "  + tree.insert(4));
        System.out.println("inserting 14: " + tree.insert(14));
        System.out.println("inserting 81: " + tree.insert(81));
        System.out.println("inserting 81: " + tree.insert(81));
        System.out.println("inserting 3: "  + tree.insert(2));
        System.out.println("inserting 77: "  + tree.insert(77));

        System.out.println(tree.getRoot());
    }

    private static void constructor() {
        tree = new BinarySearchTree();
        System.out.println(tree.getRoot());
    }
}
