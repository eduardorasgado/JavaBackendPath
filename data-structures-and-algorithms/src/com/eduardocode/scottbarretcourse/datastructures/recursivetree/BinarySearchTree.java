package com.eduardocode.scottbarretcourse.datastructures.recursivetree;

public class BinarySearchTree {
    private Node root;

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

    public boolean insert(int value) {
        return true;
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
