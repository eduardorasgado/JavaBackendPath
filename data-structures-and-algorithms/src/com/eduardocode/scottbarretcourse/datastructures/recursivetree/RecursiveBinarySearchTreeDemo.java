package com.eduardocode.scottbarretcourse.datastructures.recursivetree;

import java.util.Arrays;

public class RecursiveBinarySearchTreeDemo {

    private static BinarySearchTree tree;

    public static void main(String[] args) {
        constructor();
        //insert();
        insert2();
        //contains();
        //delete();
        System.out.println(tree.getRoot());
        bfs();
        preOrderDFS();
        postOrderDFS();
    }

    private static void postOrderDFS() {
        System.out.println("---------- DFS: Post Order ----------");
        System.out.println(tree.postOrderDFS());
    }

    private static void preOrderDFS() {
        System.out.println("---------- DFS: Pre Order ----------");
        System.out.println(tree.preOrderDFS());
    }

    private static void bfs() {
        System.out.println("---------- BFS ----------");
        System.out.println(Arrays.toString(tree.breadthFirstSearch()));
    }

    private static void delete() {
        System.out.println("-----------deleting node in tree--------");
        System.out.println("value 30 deleted: " + tree.deleteNode(30));
        System.out.println("value 1000 deleted: " + tree.deleteNode(1000));
        System.out.println(tree.getRoot());
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
        System.out.println("inserting 77: " + tree.insert(77));
        System.out.println("inserting 32: " + tree.insert(32));
        System.out.println("inserting 33: " + tree.insert(33));
        System.out.println("inserting 40: " + tree.insert(40));
        System.out.println("inserting 45: " + tree.insert(45));

        System.out.println(tree.getRoot());
    }

    private static void insert2() {
        tree.insert(20);
        tree.insert(16);
        tree.insert(25);
        tree.insert(6);
        tree.insert(17);
        tree.insert(0);
        tree.insert(7);
        tree.insert(21);
        tree.insert(29);
        tree.insert(28);
        tree.insert(51);
        tree.insert(46);
    }

    private static void constructor() {
        tree = new BinarySearchTree();
        System.out.println(tree.getRoot());
    }
}
