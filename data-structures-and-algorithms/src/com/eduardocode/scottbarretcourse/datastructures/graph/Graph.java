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

    public void print() {
        System.out.println("{");
        for (Map.Entry<String, ArrayList<String>> vertex : adjancencyList.entrySet()) {
            System.out.println(vertex.getKey() + ": " + vertex.getValue());
//            System.out.print(vertex.getKey() + ": [");
//
//            ArrayList<String> edges = vertex.getValue();
//            for (int i = 0; i < edges.size(); i++) {
//                System.out.println(String.format(" %s", edges.get(i)));
//
//                if(i < edges.size() - 1) {
//                    System.out.print(",");
//                }
//            }
//
//            System.out.print("]");
        }

        System.out.println("}");
    }
}
