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

    boolean searchDFS(String root, String destination) {

        final var nodeDestination = new Node(destination);
        Set<Node> visited = new LinkedHashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.add(new Node(root));

        while (!stack.isEmpty()) {
            final var node = stack.pop();
            if (node.equals(nodeDestination)) {
                return true;
            }
            if (!visited.contains(node)) {
                visited.add(node);
                for (Node n: adjNodes.get(node)) {
                    stack.push(n);
                }
            }
        }

        return false;
    }

    boolean searchDFSRecursive(String root, String destination, Set<Node> visited) {

        final var nodeDestination = new Node(destination);

        final var node = new Node(root);

        visited.add(node);
        if (node.equals(nodeDestination)) {
            return true;
        }

        for (Node n: adjNodes.get(node)) {
            if (!visited.contains(n) && searchDFSRecursive(n.getLabel(), destination, visited)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
       final var graph = new Graph();
       graph.addNode("a");
       graph.addNode("b");
       graph.addNode("c");
       graph.addNode("d");
       graph.addNode("e");
       graph.addNode("f");

       graph.addBiDirectionalEdge("a", "b");
       graph.addBiDirectionalEdge("b", "c");
       graph.addOneDirectionalEdge("c", "d");
       graph.addOneDirectionalEdge("c", "a");
       graph.addOneDirectionalEdge("c", "e");
       graph.addOneDirectionalEdge("a", "f");
       graph.addOneDirectionalEdge("f", "e");

        System.out.println("Destination node has found:" + graph.searchDFS("a", "e"));
        System.out.println("Destination node has found:" + graph.searchDFSRecursive("a", "e", new LinkedHashSet<>()));
        System.out.println("Destination node has found:" + graph.searchDFSRecursive("a", "d", new LinkedHashSet<>()));
        System.out.println("Destination node has found:" + graph.searchDFSRecursive("d", "a", new LinkedHashSet<>()));
        System.out.println("Destination node has found:" + graph.searchDFSRecursive("c", "a", new LinkedHashSet<>()));
        System.out.println("Destination node has found:" + graph.searchDFSRecursive("f", "c", new LinkedHashSet<>()));
    }
}
