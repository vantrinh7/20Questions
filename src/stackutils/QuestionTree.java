package stackutils;
/**
 * This class defines a question tree with methods to ask questions and play question game
 * @author vantrinh
 *
 * @param <T> the generic type of tree
 */
public class QuestionTree<T> {
	    // A variable for the root of binary tree
		private TreeNode<T> theRoot;
		
		/**
		 * Main method that creates a DefaultBinaryTree instance
		 * 
		 * @param args
		 *            the arguments
		 */
		public static void main(String[] args) {
		}

		/**
		 * Get the root node for this tree.
		 * 
		 * @return root or null if tree is empty.
		 */
		public TreeNode<T> getRoot() {
			return theRoot;
		}

		/**
		 * Set the root node for this tree.
		 */
		public void setRoot(TreeNode<T> root) {
			theRoot = root;
		}
}
