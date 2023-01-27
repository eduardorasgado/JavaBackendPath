package com.eduardocode.scottbarretcourse.datastructures.tree;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {}

    public BinarySearchTree(int value) {
        root = new Node(value);
    }

    public void insert(int value) {
        Node newNode = new Node(value);

        if(root == null) {
            root = newNode;
        }
        else {
            Node temp = root;

            while (true) {
                if (value < temp.value) {
                    if(temp.left != null) {
                        temp = temp.left;
                    }
                    else {
                        temp.setLeft(newNode);
                        break;
                    }
                }
                else if (value > temp.value) {
                    if(temp.right != null) {
                        temp = temp.right;
                    }
                    else {
                        temp.setRight(newNode);
                        break;
                    }
                }
                else {
                    break;
                }
            }
        }
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
