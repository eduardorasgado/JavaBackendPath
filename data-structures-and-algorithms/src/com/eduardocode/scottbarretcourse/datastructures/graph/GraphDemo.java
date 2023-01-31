package com.eduardocode.scottbarretcourse.datastructures.graph;

public class GraphDemo {
    private static Graph graph = new Graph();
    public static void main(String[] args) {
        constructor();
        addEdge();
    }

    private static void addEdge() {
        System.out.println(graph.addEdge("A", "B"));
        System.out.println(graph.addEdge("A", "C"));
        graph.print();
    }

    private static void constructor() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.print();
    }
}
