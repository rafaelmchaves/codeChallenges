package graph.tree;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

}

public class BinaryTree {

    Node root;

    public void addNode(int value) {

        root = add(value, root);

    }

    Node add(int value, Node node) {

        if (node == null) {
            return new Node(value);
        }

        if (value <= node.value) {
            node.right = add(value, node.right);
        } else {
            node.left = add(value, node.left);
        }

        return node;
    }

    public static void main(String[] args) {
        final var bt = new BinaryTree();
        bt.addNode(5);
        bt.addNode(6);
    }
}
