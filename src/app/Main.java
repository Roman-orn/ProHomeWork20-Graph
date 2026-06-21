package app;

public class Main {

    static void main(String[] args) {

        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B");
        graph.addEdge("B", "A");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");

        graph.getGraphInfo();

        System.out.println("\nDoes vertex E exist: " + graph.hasVertex("E"));
        System.out.println("Is there an edge between vertices B and A: " + graph.hasEdge("B", "A"));

        graph.removeVertex("D");
        graph.removeEdge("A", "B");

        graph.getGraphInfo();
    }
}
