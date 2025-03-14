package ccircularlinkedlist;

public class Test {
	 public static void main(String[] args) {
	        CircularLinkedList cll = new CircularLinkedList();
	        cll.insertAtEnd(10);
	        cll.insertAtEnd(20);
	        cll.insertAtEnd(30);
	        cll.insertAtBeginning(5);
	        cll.display();
	        
	        cll.deleteNode(20);
	        cll.display();
	        
	        System.out.println("Search 10: " + cll.search(10));
	        System.out.println("Search 50: " + cll.search(50));

	        cll.insertAt(2, 15);
	        cll.display();

	        cll.deleteAt(1);
	        cll.display();

	        System.out.println("First Element: " + cll.getFirst());
	        System.out.println("Last Element: " + cll.getLast());

	        cll.reverse();
	        cll.display();

	        int[] array = cll.toArray();
	        System.out.print("Array: ");
	        for (int num : array) {
	            System.out.print(num + " ");
	        }
	        System.out.println();
	    }

}
