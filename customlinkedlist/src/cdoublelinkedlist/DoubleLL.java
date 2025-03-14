package cdoublelinkedlist;

public class DoubleLL {
	private Node head;
	private Node tail;
	private int size;

	public DoubleLL() {
		this.size = 0;
	}

	private class Node {
		private int value;
		private Node prev;
		private Node next;

		// Constructor with both next and prev references
		public Node(int value, Node prev, Node next) {
			this.value = value;
			this.prev = prev;
			this.next = next;
		}

		// Constructor for a single node
		public Node(int value) {
			this.value = value;
		}
	}

	public void addFirst(int value) {
	    Node node = new Node(value);

	    if (head == null) {
	        head = node;
	        tail = node; // Since it's the only node, head and tail are the same
	    } else {
	        node.next = head;  // Point new node to old head
	        head.prev = node;  // Update old head's previous to new node
	        head = node;       // Move head to new node
	    }
	    
	    size++; // Increase size
	}
	public void addLast(int value) {
	    if (head == null) {
	        addFirst(value);
	        return; // ✅ Explicitly exits after handling an empty list
	    }

	    Node node = new Node(value);
	    tail.next = node;  // Old tail points to new node
	    node.prev = tail;  // New node’s prev points to old tail
	    tail = node;       // Move tail to new node
	    size++;            // Increment size
	}
	public void insertAt(int value, int index) {
	    if (index < 0 || index > size) { // Bounds check
	        throw new IndexOutOfBoundsException("Invalid index: " + index);
	    }

	    if (index == 0) { // Insert at the beginning
	        addFirst(value);
	        return;
	    }
	    
	    if (index == size) { // Insert at the end
	        addLast(value);
	        return;
	    }

	    Node temp = head;
	    for (int i = 0; i < index - 1; i++) { // Move temp to (index - 1)
	        temp = temp.next;
	    }

	    // Create the new node
	    Node node = new Node(value);
	    node.next = temp.next;
	    node.prev = temp;
	    
	    // Reassign pointers
	    if (temp.next != null) {
	        temp.next.prev = node;
	    }
	    temp.next = node;
	    
	    size++; // Increase the size
	}
	public void deleteFirst() {
	    if (head == null) { // Check if list is empty
	        return;
	    }

	    if (head.next == null) { // If there's only one node
	        head = null;
	        tail = null;
	    } else {
	        head = head.next; // Move head to next node
	        head.prev = null; // Remove previous reference
	    }

	    size--; // Reduce size of the list
	}
	public void deleteLast() {
	    if (tail == null) { // If list is empty, do nothing
	        return;
	    }

	    if (tail == head) { // If only one node exists
	        head = null;
	        tail = null;
	    } else {
	        tail = tail.prev; // Move tail to the previous node
	        tail.next = null; // Remove reference to the deleted node
	    }

	    size--; // Reduce size
	}
	public void deleteAt(int index) {
	    if (index < 0 || index >= size) { // Prevent out-of-bounds access
	        throw new IndexOutOfBoundsException("Invalid index");
	    }

	    if (index == 0) { 
	        deleteFirst();
	        return;
	    }

	    if (index == size - 1) { 
	        deleteLast();
	        return;
	    }

	    Node temp = head;
	    for (int i = 0; i < index - 1 && temp != null; i++) {
	        temp = temp.next;
	    }

	    if (temp == null || temp.next == null) { // Safety check
	        return;
	    }

	    Node toDelete = temp.next; 
	    temp.next = toDelete.next;

	    if (toDelete.next != null) { // Ensure we don't access null
	        toDelete.next.prev = temp;
	    }

	    size--;
	}
	public void display() {
	    Node temp = head;
	    System.out.print("List: ");
	    while (temp != null) {
	        System.out.print(temp.value + " <=> ");
	        temp = temp.next;
	    }
	    System.out.println("END");
	}
	public void reverseDisplay() {
	    Node temp = tail;
	    System.out.print("Reversed List: ");
	    while (temp != null) {
	        System.out.print(temp.value + " <=> ");
	        temp = temp.prev;
	    }
	    System.out.println("START");
	}
	public void reverse() {
	    Node current = head;
	    Node temp = null;
	    
	    while (current != null) {
	        // Swap next and prev pointers
	        temp = current.prev;
	        current.prev = current.next;
	        current.next = temp;

	        // Move to the next node (which is now in prev)
	        current = current.prev;
	    }

	    // Swap head and tail
	    if (temp != null) {
	        head = temp.prev;
	    }
	}
public static void main(String[] args) {
	DoubleLL list = new DoubleLL();
	list.addFirst(10);
	list.addFirst(20);
	list.addFirst(30);

	list.display();         // Output: 30 <=> 20 <=> 10 <=> END
	list.reverse();
	list.display();         // Output: 10 <=> 20 <=> 30 <=> END
	list.reverseDisplay();  // Output: 30 <=> 20 <=> 10 <=> START

}

}
