package graph.algorithms;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Node {
    private final String label;

    public Node(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(label, node.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
