package com.eduardocode.scottbarretcourse.datastructures.tree;

public class BinarySearchTreeDemo {

    public static void main(String[] args) {
        insert();
    }

    private static void insert() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(34);
        tree.insert(4);
        tree.insert(14);
        tree.insert(81);
        tree.insert(81);

        System.out.println(tree.getRoot());
    }

    private static void constructor() {
        BinarySearchTree tree = new BinarySearchTree();
        System.out.println(tree.getRoot());
    }
}
