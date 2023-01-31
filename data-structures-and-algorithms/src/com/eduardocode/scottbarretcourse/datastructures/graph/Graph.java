package com.eduardocode.scottbarretcourse.datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {
    private HashMap<String, ArrayList<String>> adjancencyList;

    public Graph() {
        adjancencyList = new HashMap<>();
    }

    public boolean addVertex(String vertex) {
        if(!adjancencyList.containsKey(vertex)) {
            adjancencyList.put(vertex, new ArrayList<>());

            return true;
        }

        return false;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if(adjancencyList.containsKey(vertex1) && adjancencyList.containsKey(vertex2)) {
            adjancencyList.get(vertex1).add(vertex2);
            adjancencyList.get(vertex2).add(vertex1);

            return true;
        }
        return false;
    }

    public void print() {
        System.out.println("{");
        for (Map.Entry<String, ArrayList<String>> vertex : adjancencyList.entrySet()) {
            System.out.println(vertex.getKey() + ": " + vertex.getValue());
        }

        System.out.println("}");
    }
}
