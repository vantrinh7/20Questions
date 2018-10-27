package stackutils;
/**
 * This class provides the application for GUI version of unrestricted 20 Questions Game
 * 
 * @author vantrinh
 *
 */
import javax.swing.JFrame;

public class UnrestrictedGuessingGameGUIApplication {
	// The height of frame
	public static int FRAME_WIDTH = 800;
	// The width of frame
	public static int FRAME_HEIGHT = 600;

	/**
	 * Create a JFrame that holds the board of 20 Questions Game
	 * 
	 * @param args
	 *            the argument
	 **/
	public static void main(String[] args) {
		// A new GUI frame
		JFrame guiFrame;
        
		// Create a new frame for 20 Questions game
		guiFrame = new JFrame("20 Questions Game");

		// Set size of the frame
		guiFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		// Add the label of the game GUI Controller
		guiFrame.add(new UnrestrictedGuessingGameController());

		// Exit normally on closing the window
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Show the frame
		guiFrame.setVisible(true);
	}
}
