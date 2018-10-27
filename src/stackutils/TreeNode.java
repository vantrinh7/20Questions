package stackutils;
/**
 * This class defines a basic tree node, having methods to get data, set data,
 * set and get the left and right children, and check whether there is no leaf.
 * 
 * @author vantrinh
 *
 * @param <T>
 *            the generic type of the tree node
 */
public class TreeNode<T> {
	// The data passed in
		private T theData;

		// The left and right nodes
		private TreeNode<T> theRight, theLeft;

		/**
		 * Get the data stored at this node.
		 * 
		 * @return Object data.
		 */
		public T getData() {
			return theData;

		}

		/**
		 * Set the data stored at this node.
		 */
		public void setData(T data) {
			theData = data;
		}

		/**
		 * Get the left child.
		 * 
		 * @return BinaryTreeNode that is left child, or null if no child.
		 */
		public TreeNode<T> getLeftChild() {
			return theLeft;
		}

		/**
		 * Get the right child.
		 * 
		 * @return BinaryTreeNode that is right child, or null if no child.
		 */
		public TreeNode<T> getRightChild() {
			return theRight;
		}

		/**
		 * Set the left child.
		 */
		public void setLeftChild(TreeNode<T> left) {
			theLeft = left;
		}

		/**
		 * Set the right child.
		 */
		public void setRightChild(TreeNode<T> right) {
			theRight = right;
		}

		/**
		 * Tests if this node is a leaf (has no children).
		 * 
		 * @return true if leaf node.
		 */
		public boolean isLeaf() {
			return theLeft == null && theRight == null;

		}
}
