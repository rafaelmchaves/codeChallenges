package linkedlist;

import java.util.Optional;

class NodeGeneric<T> {

    T value;
    NodeGeneric<T> next;

    NodeGeneric(T value) {
        this.value = value;
        this.next = null;
    }
}
public class LinkedListGeneric {

    public NodeGeneric<Person> head;
    public NodeGeneric<Person> tail;


    public LinkedListGeneric() {
        head = null;
        tail = null;
    }

    public void append(Person person) {

        final var newNode = new NodeGeneric<>(person);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;

    }

    public void printList() {

        var current = head;
        while (current != null) {
            Person person = current.value;
            System.out.println("Name: " + person.getName() + " - occupation: " + person.getOccupation());
            current = current.next;
        }

    }

    public Optional<Person> findByName(String name) {
        var current = head;
        while (current != null) {
            if (current.value.getName().equals(name)) {
                return Optional.of(current.value);
            }

            current = current.next;
        }

        return Optional.empty();
    }

    public static void main(String[] args) {
        LinkedListGeneric linkedList = new LinkedListGeneric();
        linkedList.append(new Person("Rafael", "Developer"));
        linkedList.append(new Person("Jose", "Doctor"));
        linkedList.append(new Person("Maria", "Engineer"));

        linkedList.printList();

        getByName(linkedList, "Rafael");
        getByName(linkedList, "Pedro");
    }

    private static void getByName(LinkedListGeneric linkedList, String name) {
        linkedList.findByName(name).ifPresentOrElse(person -> System.out.println("We found the person. Occupation:" + person.getOccupation()),
                () ->  System.out.println("There is no one with this name in the list"));
    }
}
