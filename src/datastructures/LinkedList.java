package datastructures;
/**
 * This class creates a linked list that has method to get the first and last
 * node insert nodes at the beginning, the middle or the end, delete nodes,
 * check the size and if stack is empty
 * 
 * @author Van Trinh
 *
 * @param <T>
 *            the generic type of the value
 */

public class LinkedList<T> {
	// The first node of the list
	private LinkedListNode<T> head;

	/**
	 * Linked list constructor Create an empty list
	 */
	public LinkedList() {
		head = null;
	}

	/**
	 * Get data stored in head node of list.
	 * 
	 * @return data of the first node
	 */
	public T getFirst() {
		// If the head is not null
		if (head != null) {
			// Return the data at the head node
			return head.getData();
		}// Otherwise return null
		return null;
	}

	/**
	 * Get the head node of the list.
	 * 
	 * @return the first node
	 */
	public LinkedListNode<T> getFirstNode() {
		// Return the first node
		return head;

	}

	/**
	 * Get data stored in last node of list.
	 * 
	 * @return data of the last node
	 */
	public T getLast() {
		// Create a new node
		LinkedListNode<T> lastNode = new LinkedListNode<T>();
		// Iterate through the whole list
		for (LinkedListNode<T> node = head; node != null; node = node.getNext()) {
			// If node after this node is null, return this node
			if (node.getNext() == null) {
				lastNode = node;
			}
		}
		return lastNode.getData();

	}

	/**
	 * Get the tail node of the list.
	 */
	public LinkedListNode<T> getLastNode() {
		// Iterate through the whole list
		for (LinkedListNode<T> node = head; node != null; node = node.getNext()) {
			// If node after this node is null, return this node
			if (node.getNext() == null) {
				return node;
			}
		}
		return null;
	}

	/**
	 * Insert a new node with data at the head of the list.
	 */
	public void insertFirst(T data) {
		// If the head is null
		if (head == null) {
			// Create a head
			head = new LinkedListNode<T>();
			// Insert data into it
			head.setData(data);
		} else {// If head is not null
			// Create a new node
			LinkedListNode<T> newNode = new LinkedListNode<T>();
			// Insert data into this new node
			newNode.setData(data);
			// Set the head to be the next of this new node
			newNode.setNext(head);
			// Set this new node to be the head
			head = newNode;
		}
	}

	/**
	 * Insert a new node with data after currentNode
	 */
	public void insertAfter(LinkedListNode<T> currentNode, T data) {
		// Create a new node
		LinkedListNode<T> newNode = new LinkedListNode<T>();
		// Insert data into this new node
		newNode.setData(data);

		// Iterate through the whole list
		for (LinkedListNode<T> node = head; node != null; node = node.getNext()) {
			// If gets to the currentNode
			if (node == currentNode) {
				// To get the new node into the list
				// Set the next of the new node to be the next of the current
				// node
				newNode.setNext(currentNode.getNext());
				// The set the next of the current node to be the new node
				currentNode.setNext(newNode);
			}
		}
	}

	/**
	 * Insert a new node with data at the end of the list.
	 */
	public void insertLast(LinkedListNode<T> newNode) {
		// Create a new variable for current node
		LinkedListNode<T> currentNode = new LinkedListNode<T>();
		// Set current node to be equal to head value
		currentNode = head;
		// If the head node is empty - its value is null
		if (currentNode == null) {
			// Assign the new node (considered last node) to head;
			head = newNode;
		} else {
			// Otherwise if head node is not empty
			// Loop while next node is not null
			while (currentNode.getNext() != null) {
				// Move on to the next node
				currentNode = currentNode.getNext();
			}
			// If next node is null, then it is the last node
			currentNode.setNext(newNode);
		}
	}

	/**
	 * Remove the first node
	 */
	public void deleteFirst() {
		// Set the node after the head to head
		head = head.getNext();
	}

	/**
	 * Remove the last node
	 */
	public void deleteLast() {
		if (isEmpty())
			return;
		if (size() == 1) {
			head = null;
			return;
		}
		// Create a new node representing the current node
		LinkedListNode<T> currentNode = new LinkedListNode<T>();
		// Assign the value of head to this node variable, so we don't lose
		// head value
		currentNode = head;

		while (currentNode.getNext() != null) {
			// If the node after the next value is not null
			if (currentNode.getNext().getNext() != null) {
				// Moves on to the next node
				currentNode = currentNode.getNext();
			} else {
				// If the node after the next value is null
				// Set the next value to be null(delete this value)
				currentNode.setNext(null);
				return;
			}
		}
	}

	/**
	 * Remove node following currentNode If no node exists (i.e., currentNode is
	 * the tail), do nothing
	 */
	public void deleteNext(LinkedListNode<T> currentNode) {
		if (currentNode.getNext() == null)
			return;
		currentNode.setNext(currentNode.getNext().getNext());
	}

	/**
	 * Return the number of nodes in this list.
	 * 
	 * @return size of the list
	 */
	public int size() {
		// Initialize a counter
		int counter = 0;
		// For a node starting at the head, count if node is not null
		for (LinkedListNode<T> node = head; node != null; node = node.getNext()) {
			counter++;
		}
		return counter;
	}

	/**
	 * Check if list is empty.
	 * 
	 * @return true if list contains no items.
	 */
	public boolean isEmpty() {
		// Return true is head is null
		return head == null;
	}

	/**
	 * Return a String representation of the list.
	 * 
	 * @return a string of the list
	 */
	public String toString() {
		// Initialize a string variable
		String list = "";

		// For a node starting at the head, loop if node is not null
		for (LinkedListNode<T> node = head; node != null; node = node.getNext()) {
			// Add the representation of each node to the string
			// If next node is null, print out only the node
			if (node.getNext() == null) {
				list = list + node.toString();
			} else {// If node is the head, print out node and an arrow
				list = list + node.toString() + " -> ";
			}
		}
		return list;

	}
}
