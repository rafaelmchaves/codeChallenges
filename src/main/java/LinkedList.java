class Node {
    int data;
    Node next;

    // Constructor to create a new node
    Node(int d) {
        data = d;
        next = null;
    }
}

public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    //O(1)
    public void append(int new_data) {
        Node new_node = new Node(new_data);

        if (head == null) {
            head = new_node;
            tail = new_node;
            return;
        }

        tail.next = new_node;
        tail = new_node;
    }

    // Method to prepend a new node
    public void prepend(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    // Method to delete a node with given key
    public void deleteNode(int key) {
        Node temp = head, prev = null;

        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }

        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) return;

        prev.next = temp.next;
    }

    // Method to print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method to test the LinkedList implementation
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.printList();  // Output: 1 2 3 4

        linkedList.prepend(0);
        linkedList.printList();  // Output: 0 1 2 3 4

        linkedList.deleteNode(2);
        linkedList.printList();  // Output: 0 1 3 4
    }
}
