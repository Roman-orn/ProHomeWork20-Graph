package app;

import java.util.*;

public class Graph {

    private final Map<String, List<String>> graph = new HashMap<>();

    public void addVertex(String vertex) {
        graph.putIfAbsent(vertex, new ArrayList<>());
    }

    public boolean hasVertex(String vertex) {
        if(graph.get(vertex) == null) {
            return false;
        };

        return true;
    }

    public void addEdge(String source, String destination) {
        if(hasVertex(source) && hasVertex(destination)) {
            graph.get(source).add(destination);
        }
    }

    public boolean hasEdge(String source, String destination) {
        if(hasVertex(source) && hasVertex(destination)) {
            List<String> listEdges = graph.get(source);
            return listEdges.contains(destination);
        }

        return false;
    }

    public void removeVertex(String vertex) {
        if(!hasVertex(vertex)) {
            return;
        }

        graph.remove(vertex);
        for (List<String> listEdges : graph.values()) {
            listEdges.remove(vertex);
        }
    }

    public void removeEdge(String source, String destination) {
        if(hasVertex(source) && hasVertex(destination)) {
            List<String> listEdges = graph.get(source);
            listEdges.remove(destination);
        }
    }

    public void getGraphInfo() {
        graph.forEach((vertex, edges) -> {
            System.out.printf("Vertex %s has edges %s\n", vertex, edges);
        });
    }
}
