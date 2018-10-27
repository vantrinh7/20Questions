package stackutils;
/**
 * This class uses JAXP, the XML reading API provided by Java 
 * to translate XML file into a format a Java program can use
 * @author Van Trinh
 *
 */

import javax.xml.parsers.*;
import org.xml.sax.SAXException;
import org.w3c.dom.*;
import java.io.*;

public class QuestionFileReader {
	
	//Create a new variable for tree
	private QuestionTree<String> decisionTree;

	/**
	 * Main method gets document and have try catch block
	 * 
	 * @param args
	 *            the argument
	 */
	public QuestionFileReader() {
		// Setup XML Document
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		File xmlFile = new File("Questions&Answers.xml");
		// Use a try catch block to prevent exceptions from crashing the program
		try {
			// Build a document
			DocumentBuilder builder = factory.newDocumentBuilder();
			// Parse file from the builder
			Document document = builder.parse(xmlFile);
			// Parse the document into decision tree
			decisionTree = parseIntoDecisionTree(document);
        //Catch the exceptions
		} catch (ParserConfigurationException pce) {
			System.out.println("Error: ParserConfigurationException ");
		} catch (SAXException saxe) {
			System.out.println("Error: SAXException");
		} catch (IOException ioe) {
			System.out.println("Error: IOException");
		}
	}

	/**
	 * Method to parse document into decision tree
	 * @param doc the document to be parsed
	 * @return the tree
	 */
	public QuestionTree<String> parseIntoDecisionTree(Document doc){
		//Create a new tree
		QuestionTree<String> newTree = new QuestionTree<String>();
		// Create a new tree node as root
		TreeNode<String> root = new TreeNode<String>();
		// Get root node of the document
		Element docRoot = doc.getDocumentElement();		
		//Parse the root as a decision tree node
		root = parseXMLQuestionElementIntoDTNode(docRoot);		
		//Set root node to be root of the tree 
		newTree.setRoot(root);			
		return newTree;
		
	}

	/**
	 * This method parses the XML question data into a decision tree node
	 * @param currentElt the current element being parsed
	 */
	public TreeNode<String> parseXMLQuestionElementIntoDTNode(Element currentElt) {
		// Create a new tree node
		TreeNode<String> treeNode = new TreeNode<String>();
		
		// If tag name of the element is "question"
		if (currentElt.getTagName() == "question") {
			// Set node to have the question text
			treeNode.setData(currentElt.getAttribute("text"));
			// Get all children of this element
			NodeList myList = currentElt.getChildNodes();
			// Loop through this list
			for (int i = 0; i < myList.getLength(); i++) {
				// Check if each node is an element node
				if (myList.item(i).getNodeType() == Node.ELEMENT_NODE) {
					// Cast the node to Element type
					Element newElt = (Element) myList.item(i);
					// Get user answer attribute of this child element
					String answer = newElt.getAttribute("useranswer");
					// If user answer is yes
					if (answer.equals("Yes")) {	
						// Create a new node for this child
						TreeNode<String> newNode = new TreeNode<String>();
						// Parse this answer element node into a decision tree
						// node (basically calls this function again)
						newNode = parseXMLAnswerElementIntoDTNode(newElt);				
						// Set node to have the answer text
						//newNode.setData(newElt.getAttribute("text"));		
						// Set new node as Yes child (let it be the Right child)
						// of the question node being parsed
						treeNode.setRightChild(newNode);
						
					} else {// If user answer is no
						// Create a new node for this child
						TreeNode<String> newNode = new TreeNode<String>();
						// Parse this answer element node into a decision tree
						// node (basically calls this function again)
						newNode = parseXMLAnswerElementIntoDTNode(newElt);				
						// Set node to have the answer text
						//newNode.setData(newElt.getAttribute("text"));
						// Set new node as No child (let it be the Left child)
						// of the question node being parsed
						treeNode.setLeftChild(newNode);						
					}
				}
			}
		}
		
		return treeNode;
	}

	/**
	 * This method parses the XML answer data into a decision tree node
	 * @param element the current element being parsed
	 */
	public TreeNode<String> parseXMLAnswerElementIntoDTNode(Element element) {
		// If tag name of the element is "answer"
		if (element.getTagName() == "answer") {
			// Get all children of this element
			NodeList myList = element.getChildNodes();
			// Loop through this list
			for (int i = 0; i < myList.getLength(); i++) {
				// Check if each node is an element node
				if (myList.item(i).getNodeType() == Node.ELEMENT_NODE) {
					// Cast the node to Element type
					Element newElt = (Element) myList.item(i);
					//If node is a question
					if(newElt.getTagName() == "question"){
						//Call the question function again
						return parseXMLQuestionElementIntoDTNode(newElt);
					//Otherwise if it's a thing
					} else if(newElt.getTagName() == "thing"){
						// Create a new node for this child
						TreeNode<String> newNode = new TreeNode<String>();
						// Set node to have the answer text
						newNode.setData(newElt.getTextContent());
						return newNode;
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Method to get the tree created from the XML file
	 * @return the decision tree
	 */
	public QuestionTree<String> getTree(){
		return decisionTree;
	}

}