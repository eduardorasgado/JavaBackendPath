package com.eduardocode.scottbarretcourse.datastructures.graph;

public class GraphDemo {
    private static Graph graph = new Graph();
    public static void main(String[] args) {
        constructor();
        addEdge();
        removeEdge();
        removeVertex();
    }

    private static void removeVertex() {
        System.out.println("Remove vertex: " + graph.removeVertex("A"));
        graph.print();
    }

    private static void removeEdge() {
        System.out.println("Adding edge B and C: " + graph.addEdge("B", "C"));
        graph.print();
        System.out.println("Removing edge B and C: " + graph.removeEdge("C", "B"));
        graph.print();
        System.out.println("Removing edge B and C: " + graph.removeEdge("C", "B"));
        graph.print();
    }

    private static void addEdge() {
        System.out.println("Adding edge A and B: " + graph.addEdge("A", "B"));
        System.out.println("Adding edge A and C: " + graph.addEdge("A", "C"));
        System.out.println("Adding edge A and C: " + graph.addEdge("A", "C"));
        System.out.println("Adding edge A and C: " + graph.addEdge("B", "D"));
        graph.print();
    }

    private static void constructor() {
        System.out.println("Adding vertex A: " + graph.addVertex("A"));
        System.out.println("Adding vertex B: " + graph.addVertex("B"));
        System.out.println("Adding vertex C: " + graph.addVertex("C"));
        System.out.println("Adding vertex D: " + graph.addVertex("D"));
        graph.print();
    }
}
