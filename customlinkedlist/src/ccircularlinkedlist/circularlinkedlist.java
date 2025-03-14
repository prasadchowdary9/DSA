package ccircularlinkedlist;

class CircularLinkedList {
    private Node last;
    private int size;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public CircularLinkedList() {
        last = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        last = null;
        size = 0;
    }

    public int getFirst() {
        if (last == null) throw new IllegalStateException("List is empty");
        return last.next.data;
    }

    public int getLast() {
        if (last == null) throw new IllegalStateException("List is empty");
        return last.data;
    }

    public void insertAt(int index, int data) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Invalid index");
        if (index == 0) {
            insertAtBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = last.next;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        if (index == size) {
            last = newNode;
        }
        size++;
    }

    public void deleteAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index");
        if (index == 0) {
            deleteNode(last.next.data);
            return;
        }
        Node current = last.next;
        Node prev = last;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        if (current == last) {
            last = prev;
        }
        size--;
    }

    public void reverse() {
        if (last == null || last.next == last) return;
        Node prev = last, current = last.next, next;
        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != last.next);
        last.next = prev;
        last = current;
    }

    public int[] toArray() {
        int[] array = new int[size];
        if (last == null) return array;
        Node current = last.next;
        int i = 0;
        do {
            array[i++] = current.data;
            current = current.next;
        } while (current != last.next);
        return array;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
        }
        size++;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public void deleteNode(int key) {
        if (last == null) return;
        Node current = last.next, prev = last;
        do {
            if (current.data == key) {
                if (current == last.next) {
                    last.next = current.next;
                } else if (current == last) {
                    prev.next = last.next;
                    last = prev;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);
    }

    public boolean search(int key) {
        if (last == null) return false;
        Node current = last.next;
        do {
            if (current.data == key) return true;
            current = current.next;
        } while (current != last.next);
        return false;
    }

    public void display() {
        if (last == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = last.next;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != last.next);
        System.out.println("(back to start)");
    }

   
}