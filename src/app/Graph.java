package app;

import java.util.*;

public class Graph {

    private final Map<String, Set<String>> graph = new HashMap<>();

    public void addVertex(String vertex) {

        graph.putIfAbsent(vertex, new HashSet<>());
    }

    public boolean hasVertex(String vertex) {

        return graph.get(vertex) != null;
    }

    public void addEdge(String source, String destination) {
        addVertex(source);
        addVertex(destination);
        graph.get(source).add(destination);
    }

    public boolean hasEdge(String source, String destination) {
        if (hasVertex(source) && hasVertex(destination)) {
            Set<String> listEdges = graph.get(source);
            return listEdges.contains(destination);
        }

        return false;
    }

    public void removeVertex(String vertex) {
        if (!hasVertex(vertex)) {
            return;
        }

        for (Set<String> listEdges : graph.values()) {
            listEdges.remove(vertex);
        }

        graph.remove(vertex);
    }

    public void removeEdge(String source, String destination) {
        if (hasVertex(source) && hasVertex(destination)) {
            Set<String> listEdges = graph.get(source);
            listEdges.remove(destination);
        }
    }

    public void getGraphInfo() {
        graph.forEach((vertex, edges) -> {
            System.out.printf("Vertex %s has edges %s\n", vertex, edges);
        });
    }
}
