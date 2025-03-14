package clinkedlist;



import java.util.NoSuchElementException;

public class LL {

    private Node head;
    private int size;

    public LL() {
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    // Add element at the beginning
    public void addFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        size++;
    }

    // Add element at the end
    public void addLast(int value) {
        if (head == null) {
            addFirst(value);
            return;
        }
        Node node = new Node(value);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        size++;
    }

    // Insert element at a specific index
    public void insertAt(int value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        if (index == 0) {
            addFirst(value);
            return;
        }

        Node newNode = new Node(value);
        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    // Display linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " => ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // Delete first node
    public int deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        int value = head.value;
        head = head.next;
        size--;
        return value;
    }

    // Delete last node
    public int deleteLast() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        if (head.next == null) { // If only one node exists
            int value = head.value;
            head = null;
            size--;
            return value;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        int value = temp.next.value;
        temp.next = null;
        size--;
        return value;
    }

    // Delete node at a specific index
    public int deleteAt(int index) {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        if (index == 0) {
            return deleteFirst();
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        int value = temp.next.value;
        temp.next = temp.next.next;
        size--;
        return value;
    }

    // Get the size of the linked list
    public int size() {
        return size;
    }

    // Reverse the linked list (iterative)
    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }

        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    // Test the LinkedList
    public static void main(String[] args) {
        LL list = new LL();

        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(4);
        list.addLast(5);

        System.out.println("Original List:");
        list.display();

        list.insertAt(10, 2);
        System.out.println("After inserting 10 at index 2:");
        list.display();

        list.deleteFirst();
        System.out.println("After deleting first node:");
        list.display();

        list.deleteLast();
        System.out.println("After deleting last node:");
        list.display();

        list.deleteAt(2);
        System.out.println("After deleting node at index 2:");
        list.display();

        System.out.println("Size of list: " + list.size());

        list.reverse();
        System.out.println("After reversing the list:");
        list.display();
    }
}
