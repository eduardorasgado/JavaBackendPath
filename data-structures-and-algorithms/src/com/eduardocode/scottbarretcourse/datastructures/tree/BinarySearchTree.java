package com.eduardocode.scottbarretcourse.datastructures.tree;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {}

    public BinarySearchTree(int value) {
        root = new Node(value);
    }

    class Node {
        public int value;
        public Node left;
        public Node right;

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
