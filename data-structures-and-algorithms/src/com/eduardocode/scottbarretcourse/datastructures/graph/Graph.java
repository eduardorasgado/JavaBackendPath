package com.eduardocode.scottbarretcourse.datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {
    private final HashMap<String, ArrayList<String>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public boolean addVertex(String vertex) {
        if(adjacencyList.containsKey(vertex)) {
            return false;
        }

        adjacencyList.put(vertex, new ArrayList<>());
        return true;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if(!containsVertexPair(vertex1, vertex2) || containsEdge(vertex1, vertex2)) {
            return false;
        }
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);

        return true;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if(!containsVertexPair(vertex1, vertex2) || !containsEdge(vertex1, vertex2)) {
            return false;
        }

        adjacencyList.get(vertex1).remove(vertex2);
        adjacencyList.get(vertex2).remove(vertex1);

        return true;
    }

    public boolean removeVertex(String vertex) {
        if(!adjacencyList.containsKey(vertex)) {
            return false;
        }

        for(String edge : adjacencyList.get(vertex)) {
            adjacencyList.get(edge).remove(vertex);
        }

        adjacencyList.remove(vertex);
        return true;
    }

    private boolean containsVertexPair(String vertex1, String vertex2) {
        return adjacencyList.containsKey(vertex1) && adjacencyList.containsKey(vertex2);
    }

    private boolean containsEdge(String vertex1, String vertex2) {
        return adjacencyList.get(vertex1).contains(vertex2) && adjacencyList.get(vertex2).contains(vertex1);
    }

    public void print() {
        System.out.println("{");

        for (Map.Entry<String, ArrayList<String>> vertex : adjacencyList.entrySet()) {
            System.out.println(vertex.getKey() + ": " + vertex.getValue());
        }

        System.out.println("}");
    }
}
