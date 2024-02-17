package graph.algorithms;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(of = "label")
public class Node {
    private final String label;

    public Node(String label) {
        this.label = label;
    }

}
