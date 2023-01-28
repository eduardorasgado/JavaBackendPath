package com.eduardocode.scottbarretcourse.datastructures.tree;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {}

    public BinarySearchTree(int value) {
        root = new Node(value);
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);

        if(root == null) {
            root = newNode;
            return true;
        }
        else {
            Node temp = root;

            while (true) {
                if(value == temp.value) return false;

                if (value < temp.value) {
                    if(temp.left == null) {
                        temp.setLeft(newNode);
                        return true;
                    }

                    temp = temp.left;
                }
                else {
                    if(temp.right == null) {
                        temp.setRight(newNode);
                        return true;
                    }

                    temp = temp.right;
                }
            }
        }
    }

    public boolean contains(int value) {
        if(root == null) return false;

        Node temp = root;

        while (temp != null) {
            if(temp.value == value)
                return true;
            else if(value < temp.value)
                temp = temp.left;
            else
                temp = temp.right;
        }

        return false;
    }

    public Node getRoot() {
        return root;
    }

    class Node {
        public int value;
        public Node left;
        public Node right;

        private int depth;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return NodePrintFormatter.getNodePrintingChars(this);
        }

        public int getDepth() {
            return depth;
        }

        public void setDepth(int depth) {
            this.depth = depth + 1;
        }

        public void setLeft(Node newNode) {
            newNode.setDepth(getDepth());
            left = newNode;
        }

        public void setRight(Node newNode) {
            newNode.setDepth(getDepth());
            right = newNode;
        }
    }
}
