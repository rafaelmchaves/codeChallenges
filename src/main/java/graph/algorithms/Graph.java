package graph.algorithms;
import java.util.*;

public class Graph {

    public Map<Node, List<Node>> adjNodes;

    public Graph() {
        this.adjNodes = new HashMap<>();
    }

    void addNode(String label) {
        adjNodes.putIfAbsent(new Node(label), new ArrayList<>());
    }

    void addOneDirectionalEdge(String labelA, String labelB) {
        adjNodes.get(new Node(labelA)).add(new Node(labelB));
    }

    void addBiDirectionalEdge(String labelA, String labelB) {
        final var nodeA = new Node(labelA);
        final var nodeB = new Node(labelB);

        adjNodes.get(nodeA).add(nodeB);
        adjNodes.get(nodeB).add(nodeA);
    }

    public static void main(String[] args) {
       final var graph = new Graph();
       graph.addNode("a");
       graph.addNode("b");
       graph.addNode("c");
       graph.addNode("d");

       graph.addBiDirectionalEdge("a", "b");
       graph.addOneDirectionalEdge("a", "c");
       graph.addBiDirectionalEdge("b", "c");
       graph.addOneDirectionalEdge("c", "d");
    }
}
