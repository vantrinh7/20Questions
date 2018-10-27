package stackutils;

/**
 * 
 * A panel that is responsible for key events and keeping track of the game
 * It is the "Controller" in the Model-View-Controller
 * 
 * This controller is for the Unrestricted Guessing Game
 * @author VanTrinh
 *
 */
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.*;

public class UnrestrictedGuessingGameController extends JPanel implements ActionListener {

	// A variable for the new tree
	private QuestionTree<String> newTree;
	// A variable for tree node
	private TreeNode<String> currentNode;
	// Variable for yes button
	private JButton yesBtn;
	// Variable for no button
	private JButton noBtn;
	// Variable for restart button
	private JButton restartBtn;
	// Variable for question label
	private JLabel question;

	/**
	 * Constructor of this class
	 */
	public UnrestrictedGuessingGameController() {
		// Call the super method
		super(new BorderLayout());
		// Get tree out of the xml file reader
		QuestionFileReader fileReader = new QuestionFileReader();
		newTree = fileReader.getTree();
		currentNode = newTree.getRoot();
		// Create the view
		createView();
	}

	/**
	 * Method to create the view of the controller
	 */
	public void createView() {
		// Create a new label for instructions
		JLabel instructions = new JLabel(
				"<html><u><b>Instruction to play game</b></u><br><br>Choose of one of these animals (or any other that you like) and picture it for a moment:<br><br>Dog, Spider, Snake, Jellyfish, Earthworm, Bear, Elephant, Starfish, Horse, Goose,<br> Butterfly, Shark, Parrot, Owl, Clam, Crocodile, Frog, Tiger</html>");
		// Create a new label for question, set font
		question = new JLabel("Question here");
		question.setFont(new Font("Serif", Font.BOLD, 36));

		// Create new buttons for yes, no and restart and change size
		yesBtn = new JButton("Yes");
		yesBtn.setPreferredSize(new Dimension(200, 100));
		noBtn = new JButton("No");
		noBtn.setPreferredSize(new Dimension(200, 100));
		restartBtn = new JButton("Restart");
		restartBtn.setPreferredSize(new Dimension(200, 100));

		// Add listeners to buttons
		yesBtn.addActionListener(this);
		noBtn.addActionListener(this);
		restartBtn.addActionListener(this);

		// Create a new panel
		JPanel newPanel = new JPanel(new GridBagLayout());
		// Add this new panel to the center
		this.add(newPanel, BorderLayout.CENTER);
		// Create grid bag constraints for the items
		GridBagConstraints c = new GridBagConstraints();

		// Adding instruction label
		// Number of cells in a column is 1
		c.gridheight = 1;
		// Number of cells in a row to fill up is 3
		c.gridwidth = 3;
		// Space between the buttons is 0.1
		c.weighty = 0.1;
		// Cell of the row that contains the leading corner of the display area
		// is the first cell in a row
		c.gridx = 0;
		// Cell of the column that contains the leading corner of the display
		// area
		// is the first cell in a column
		c.gridy = 0;
		// Add instruction label
		newPanel.add(instructions, c);

		// Adding question label
		// Number of cells in a row to fill up is 3
		c.gridwidth = 3;
		// Cell of the row that contains the leading corner of the display area
		// is the first cell in a row
		c.gridx = 0;
		// Cell of the row that contains the leading corner of the display area
		// is the second cell in a column
		c.gridy = 1;
		// Add question label
		newPanel.add(question, c);

		// Adding Yes button
		// Number of cells in a row to fill up is 1
		c.gridwidth = 1;
		// Change the weight (distribution of space)
		c.weightx = 0.001;
		// Cell of the row that contains the leading corner of the display area
		// is the first cell in a row
		c.gridx = 0;
		// Cell of the row that contains the leading corner of the display area
		// is the third cell in a column
		c.gridy = 2;
		// Add yes button
		newPanel.add(yesBtn, c);

		// Adding No button
		// Number of cells in a row to fill up is 1
		c.gridwidth = 1;
		// Cell of the row that contains the leading corner of the display area
		// is the second cell in a row
		c.gridx = 1;
		// Cell of the row that contains the leading corner of the display area
		// is the third cell in a column
		c.gridy = 2;
		// Add no button
		newPanel.add(noBtn, c);

		// Adding Restart button
		// Number of cells in a row to fill up is 1
		c.gridwidth = 1;
		// Cell of the row that contains the leading corner of the display area
		// is the second cell in a row
		c.gridx = 2;
		// Cell of the row that contains the leading corner of the display area
		// is the third cell in a column
		c.gridy = 2;
		// Add no button
		newPanel.add(restartBtn, c);

		// Set color of the background and make sure it's opaque so we can see
		// it
		newPanel.setBackground(new Color(168, 218, 247));
		newPanel.setOpaque(true);
		
		// Display the root on the screen
		toJLabel(newTree.getRoot());
	}

	/**
	 * This method changes the label according to the data on the node
	 * 
	 * @param the
	 *            node being passed in
	 */
	public void toJLabel(TreeNode<String> node) {
		//If node is not leaf
		if (!node.isLeaf()) {
			// Set the text of the question label to the one of the node
			question.setText(node.getData());
		} else {
			//If node is leaf, add text
			question.setText("You might have thought of: " + node.getData());
		}
		question.setFont(new Font("Serif", Font.BOLD, 36));
		// Validate
		this.validate();
		// Repaint
		this.repaint();

	}

	/**
	 * This method requests input from user after the final answer pops up
	 * 
	 * @param childSide
	 *            left or right, where the unwanted answer comes from
	 */
	public void inputRequest(String childSide) {
		// Prompt a message to ask user whether this is the correct answer
		int option = JOptionPane.showConfirmDialog(null, "Is this the answer you want?", "", JOptionPane.YES_NO_OPTION);
		// If user chooses Yes, give a message
		if (option == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Great! Thanks for playing! Hit Restart to play again :)");
			// If user chooses No, ask for input
		} else if (option == JOptionPane.NO_OPTION) {
			// Ask for the animal user was thinking of
			String desiredAnimal = JOptionPane.showInputDialog(null, "What is the animal you were thinking of?");
			// Ask for a question to give this answer
			String desiredQuestion = JOptionPane.showInputDialog(null,
					"Please give me a Yes/No question that would have determined your animal:");
			// Ask for an answer to this question
			int desiredAnswer = JOptionPane.showConfirmDialog(null, "Is the answer to your question Yes or No?", "", JOptionPane.YES_NO_OPTION);
			// Modify the tree based on user input
			modifyTree(desiredAnimal, desiredQuestion, desiredAnswer, childSide);
			// Give instruction message
			JOptionPane.showMessageDialog(null, "Great! Hit Restart to play again :)");
		}
	}

	/**
	 * This method modifies the tree based on user input
	 * 
	 * @param desiredAnimal
	 *            the animal that user was thinking of
	 * @param desiredQuestion
	 *            the question that user was thinking of
	 * @param desiredAnswer
	 *            the answer that user was thinking of
	 * @param childSide
	 *            left or right, where the unwanted answer comes from
	 */
	public void modifyTree(String desiredAnimal, String desiredQuestion, int desiredAnswer, String childSide) {
		// Create a temporary variable to hold the unwanted answer
		TreeNode<String> tempNode = new TreeNode<String>();

		// Create a new node for the new question and answer
		TreeNode<String> questionNode = new TreeNode<String>();
		TreeNode<String> answerNode = new TreeNode<String>();

		// Set question and answer data for the new nodes
		questionNode.setData(desiredQuestion);
		answerNode.setData(desiredAnimal);

		// If the unwanted answer comes from the right child
		if (childSide.equals("right")) {
			// Store right child in temp node
			tempNode = currentNode.getRightChild();
			// Set right child of current node to be the user question node
			currentNode.setRightChild(questionNode);
		} else {// If the unwanted answer comes from left child
			// Store left child in temp node
			tempNode = currentNode.getLeftChild();
			// Set left child of current node to be the user question node
			currentNode.setLeftChild(questionNode);
		}

		// If the user's answer is yes
		if (desiredAnswer == JOptionPane.YES_OPTION) {
			// Set right child to be user answer
			questionNode.setRightChild(answerNode);
			// Set left child to be the saved answer
			questionNode.setLeftChild(tempNode);
		} else if (desiredAnswer == JOptionPane.NO_OPTION){
			// Set right child to be the saved answer
			questionNode.setRightChild(tempNode);
			// Set left child to be user answer
			questionNode.setLeftChild(answerNode);
		}
	}

	/**
	 * Method to declare suitable actions according to pressed button
	 * @param e the event (such as clicking buttons)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// A variable to signify that it's the right child
		String right = "right";
		// A variable to signify that it's the left child
		String left = "left";

		// If the source is from the yes button
		if (e.getSource() == yesBtn) {
			// If the right child of current node is not leaf
			if (!currentNode.getRightChild().isLeaf()) {
				// Get current node to be the right child, change label
				currentNode = currentNode.getRightChild();
				toJLabel(currentNode);	

			} else {// Else if the right child of current node is the leaf
				// Only change the label, but keep the current node value
				toJLabel(currentNode.getRightChild());
				// Ask for user input
				inputRequest(right);
			}

			// If the source is from the no button
		} else if (e.getSource() == noBtn) {
			// If the left child of current node is not leaf
			if (!currentNode.getLeftChild().isLeaf()) {
				// Get current node to be the left child, change label
				currentNode = currentNode.getLeftChild();
				toJLabel(currentNode);

			} else {// Else if the left child of current node is the leaf
				// Only change the label, but keep the current node value
				toJLabel(currentNode.getLeftChild());
				// Ask for user input
				inputRequest(left);
			}
			
		  // If the source is from restart button
		} else if (e.getSource() == restartBtn){
			//Make current node the root of the tree again
			currentNode = newTree.getRoot();
			//Update the label
			toJLabel(currentNode);
			
		}
	}
}