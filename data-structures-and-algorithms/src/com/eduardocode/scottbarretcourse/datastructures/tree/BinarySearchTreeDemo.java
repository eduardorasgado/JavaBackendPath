package com.eduardocode.scottbarretcourse.datastructures.tree;

public class BinarySearchTreeDemo {

    public static void main(String[] args) {
        insert();
    }

    private static void insert() {
        BinarySearchTree tree = new BinarySearchTree();

        System.out.println("inserting 50: " + tree.insert(50));
        System.out.println("inserting 50: " + tree.insert(30));
        System.out.println("inserting 70: " + tree.insert(70));
        System.out.println("inserting 34: " + tree.insert(34));
        System.out.println("inserting 4: " + tree.insert(4));
        System.out.println("inserting 14: " + tree.insert(14));
        System.out.println("inserting 81: " + tree.insert(81));
        System.out.println("inserting 81: " + tree.insert(81));

        System.out.println(tree.getRoot());
    }

    private static void constructor() {
        BinarySearchTree tree = new BinarySearchTree();
        System.out.println(tree.getRoot());
    }
}
