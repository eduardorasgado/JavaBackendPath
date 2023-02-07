package com.eduardocode.scottbarretcourse.datastructures.recursivetree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public class BinarySearchTree {
    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public boolean insert(int value) {
        if(root == null) {
            root = new Node(value);
            ++size;
            return true;
        }

        if(!insert(root, value)){
            return false;
        }

        ++size;
        return true;
    }

    public void insertV2(int value) {
        // refactor to update tree size
        if(root == null) {
            root = new Node(value);
        } else {
            insertV2(root, value);
        }
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

    private Node insertV2(Node currentNode, int value) {
        if(currentNode == null) return new Node(value);

        if(value < currentNode.value) {
            currentNode.setLeft(insertV2(currentNode.left, value));
        }
        else if(value > currentNode.value) {
            currentNode.setRight(insertV2(currentNode.right, value));
        }

        return currentNode;
    }

    public boolean deleteNode(int value) {
        AtomicBoolean deleted = new AtomicBoolean(false);
        deleteNode(root, value, deleted);

        if(!deleted.get()) {
            return false;
        }

        --size;
        return true;
    }

    private Node deleteNode(Node currentNode, int value, AtomicBoolean deleted) {
        if(currentNode == null) return null;

        if(value < currentNode.value) {
            currentNode.setLeft(deleteNode(currentNode.left, value, deleted));
        }
        else if(value > currentNode.value) {
            currentNode.setRight(deleteNode(currentNode.right, value, deleted));
        }
        else {
            deleted.set(true);

            if(currentNode.left == null && currentNode.right == null) {
                currentNode = null;
            }
            else if(currentNode.left == null) {
                currentNode = currentNode.right;
            }
            else if(currentNode.right == null) {
                currentNode = currentNode.left;
            }
            else {
                int subTreeMin = minimumValue(currentNode.right);

                currentNode.value = subTreeMin;
                currentNode.setRight(deleteNode(currentNode.right, subTreeMin, deleted));
            }
        }

        return currentNode;
    }

    private int minimumValue(Node currentNode) {
        while(currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode.value;
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

    public int[] breadthFirstSearch() {
        int[] resultList = new int[size];
        Queue<Node> queue = new LinkedList<>();
        Node temp = getRoot();

        queue.add(temp);
        int i = 0;

        while (!queue.isEmpty() && i < size) {
            temp = queue.remove();
            resultList[i++] = temp.value;

            if(temp.left != null) {
                queue.add(temp.left);
            }
            if(temp.right != null) {
                queue.add(temp.right);
            }
        }

        return resultList;
    }

    public ArrayList<Integer> preOrderDFS() {
        ArrayList<Integer> resultList = new ArrayList<>();
        preOrderDFS(getRoot(), resultList);

        return resultList;
    }

    private void preOrderDFS(Node currNode, List<Integer> resultList) {
        if(currNode != null) {
            resultList.add(currNode.value);

            preOrderDFS(currNode.left, resultList);
            preOrderDFS(currNode.right, resultList);
        }
    }

    public ArrayList<Integer> postOrderDFS() {
        ArrayList<Integer> resultList = new ArrayList<>();
        postOrderDFS(getRoot(), resultList);

        return resultList;
    }

    private void postOrderDFS(Node currNode, List<Integer> resultList) {
        if(currNode != null) {
            postOrderDFS(currNode.left, resultList);
            postOrderDFS(currNode.right, resultList);
            resultList.add(currNode.value);
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
            if(newNode != null) newNode.setDepth(getDepth());
            left = newNode;
        }

        public void setRight(Node newNode) {
            if(newNode != null) newNode.setDepth(getDepth());
            right = newNode;
        }
    }
}
