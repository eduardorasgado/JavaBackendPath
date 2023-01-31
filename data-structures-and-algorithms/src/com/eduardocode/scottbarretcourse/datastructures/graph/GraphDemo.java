package com.eduardocode.scottbarretcourse.datastructures.graph;

public class GraphDemo {
    private static Graph graph = new Graph();
    public static void main(String[] args) {
        constructor();
    }

    private static void constructor() {
        graph.addVertex("A");
        graph.print();
    }
}
