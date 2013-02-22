package game;

import javax.swing.JFrame;
/**
 * Version 1.2 19.12.12
 * Finished!
 */

/**
 * This is the main class. It creates a new JFrame
 * and adds a new Board JPanel to the frame
 * @author liam
 * @version 0.3 3.12.12
 */
public class Main extends JFrame
{
	private static final long serialVersionUID = 1L;

	//Local Final Variables
	/*Screen X size*/
	private static final int X_SIZE = 220;
	/*Screen Y size*/
	private static final int Y_SIZE = 400;
	
	/**
	 * Main class constructor
	 * Sets up a JFrame and adds
	 * a new board to the frame
	 */
	public Main()
	{
		//Set up JFrame
		/*Add a new game board*/
		this.add(new Board(X_SIZE, Y_SIZE));
		/*Set the size of the Frame*/
		this.setSize(X_SIZE+21, Y_SIZE+51);
		/*Disable the ability to resize the window*/
		this.setResizable(false);
		/*Make the Frame visible*/
		this.setVisible(true);
		/*Centre the Frame*/
		this.setLocationRelativeTo(null);
		/*Close program on when close Icon clicked*/
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * Entry point into the program
	 * Creates a new Main object
	 * @param args
	 */
	public static void main(String[] args)
	{
		new Main();
	}
}
