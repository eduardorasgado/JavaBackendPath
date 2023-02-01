package com.eduardocode.scottbarretcourse.datastructures.recursivetree;

public class BinarySearchTree {
    private Node root;

    public boolean insert(int value) {
        if(root == null) {
            root = new Node(value);
            return true;
        }

        return insert(root, value);
    }

    private boolean insert(Node currentNode, int value) {
        if(value == currentNode.value) {
            return false;
        }

        if(value < currentNode.value && currentNode.left != null) {
            return insert(currentNode.left, value);
        }
        if(value > currentNode.value && currentNode.right != null) {
            return insert(currentNode.right, value);
        }

        if(value < currentNode.value) {
            currentNode.setLeft(new Node(value));
        }
        else {
            currentNode.setRight(new Node(value));
        }

        return true;
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node currentNode, int value) {
        if(currentNode == null) return false;

        if(currentNode.value == value) {
            return true;
        }
        else if(value < currentNode.value) {
            return contains(currentNode.left, value);
        }
        else {
            return contains(currentNode.right, value);
        }
    }

    public Node getRoot() {
        return root;
    }


    public class Node {
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
