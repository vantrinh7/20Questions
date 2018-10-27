package datastructures;
/**
 * This class defines a node in the linked list, provides getter and setter
 * methods of the nodes
 * 
 * @author Van Trinh
 *
 * @param <T>
 *            the generic type of the value in the node
 */

public class LinkedListNode<T> {
	// The data passed in
	private T theData;
	// The next node
	private LinkedListNode<T> nextNode;

	public LinkedListNode() {
	}

	/**
	 * Set the data stored at this node.
	 */
	public void setData(T data) {
		// Set the data stored at this node to be the data passed in
		theData = data;
		nextNode = null;
	}

	/**
	 * Get the data stored at this node.
	 */
	public T getData() {
		// Return the data
		return theData;
	}

	/**
	 * Set the next pointer to passed node.
	 */
	public void setNext(LinkedListNode<T> node) {
		nextNode = node;
	}

	/**
	 * Get (pointer to) next node.
	 */
	public LinkedListNode<T> getNext() {
		return nextNode;
	}

	/**
	 * Returns a String representation of this node.
	 */
	public String toString() {
		// A variable representing a string value
		String result = "";
		// Return the data as a string representation
		return result + this.getData();
	}

}
