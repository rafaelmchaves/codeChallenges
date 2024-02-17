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
            node.left = add(value, node.left);
        } else {
            node.right = add(value, node.right);
        }

        return node;
    }

    static void printPreOrder(Node node) {
        if (node != null) {
            System.out.println(node.value);
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    static void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.value);
            printInOrder(node.right);
        }
    }

    static void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.println(node.value);
        }
    }

    public static void main(String[] args) {
        final var bt = new BinaryTree();
        bt.addNode(5);
        bt.addNode(7);
        bt.addNode(3);
        bt.addNode(12);
        bt.addNode(6);

        printPreOrder(bt.root);
        System.out.println();
        printInOrder(bt.root);
        System.out.println();
        printPostOrder(bt.root);
    }
}
