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

    public static final int BALANCED_TREE_MAX_HEIGHT = 1;
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

    /**
     * A balanced binary tree is a binary tree that the heights of the two subtrees of any node never differ by more than one.
     * @return true if it is balanced, else false
     */
    boolean isBalanced() {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    int checkHeight(Node node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = checkHeight(node.left);
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int rightHeight = checkHeight(node.right);
        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int heightDiff = leftHeight - rightHeight;

        if (Math.abs(heightDiff) > BALANCED_TREE_MAX_HEIGHT) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(checkHeight(node.left), checkHeight(node.right)) + 1;
        }
    }

    int findElement(int value) {
        return find(value, root);
    }
    int find(int value, Node node) {

        if (node != null) {
            if (value < node.value) {
                return find(value, node.left);
            } else if (value > node.value) {
                return find(value, node.right);
            } else {
                return node.value;
            }
        }

        return -1;
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
        bt.addNode(9);

        System.out.println("Found: " + bt.findElement(7));
        System.out.println("Found: " + bt.findElement(12));
        System.out.println("Found: " + bt.findElement(5));
        System.out.println("Found: " + bt.findElement(3));
        System.out.println("Found: " + bt.findElement(6));
        System.out.println("Found: " + bt.findElement(16));

        System.out.println("is balanced: " + bt.isBalanced());

        System.out.println("Pre order:");
        printPreOrder(bt.root);
        System.out.println("In order:");
        printInOrder(bt.root);
        System.out.println("Post order:");
        printPostOrder(bt.root);
    }
}
