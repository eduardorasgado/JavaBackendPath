package com.eduardocode.scottbarretcourse.datastructures.tree;

public class NodePrintFormatter {

    public static String getNodePrintingChars(BinarySearchTree.Node node) {
        String spacing = "\n" + getDepthString(node.getDepth());

        return  spacing + "Node{" +
                spacing + ", value=" + node.value +
                spacing + ", left=" + node.left +
                spacing + ", right=" + node.right +
                spacing + '}';
    }

    private static String getDepthString(int depth) {
        return "|    ".repeat(depth);
    }
}
