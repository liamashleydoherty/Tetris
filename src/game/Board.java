package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * This class represents the game board that blocks are painted onto.
 * It contains a keyboard adapter nested class and collision detection logic
 * @author Liam A Doherty
 * @version 1.0 4.12.12
 */
public class Board extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	//Local static fields
	/*Swing timer speed*/
	private static final int TIMER_SPEED = 30;
	/*Block default fall interval*/
	private static final int FALL_INTERVAL = 10;
	/*Gap between squares*/
	private static final int GAP = 2;
	
	//Local dynamic fields
	/*X and Y size*/
	private int xSize, ySize;
	/*Fall interval counter*/
	private int counter = 1;
	/*Falling shape*/
	private Shape shape;
	/*Swing timer*/
	private Timer timer;
	/*Fallen shapes*/
	private ArrayList<Block> fallen;
	
	/**
	 * Board class constructor.
	 * Sets up the JPanel and instantiates local fields.
	 * Parameters are for the size of the screen.
	 * @param xSize
	 * @param ySize
	 */
	public Board(int xSize, int ySize)
	{
		//Set up JPanel
		/*Set screen size*/
		this.setSize(xSize, ySize);
		/*Add key listener*/
		this.addKeyListener(new KAdapter());
		/*Set focusable*/
		this.setFocusable(true);
		/*Set double buffering*/
		this.setDoubleBuffered(true);
		/*Set background colour*/
		this.setBackground(Color.BLACK);
		/*Set visibility*/
		this.setVisible(true);
		
		//Local dynamic field declarations
		/*Set X and Y size*/
		this.xSize = xSize;
		this.ySize = ySize;
		
		//Instantiate objects
		/*Fallen blocks array list*/
		fallen = new ArrayList<Block>();
		/*Add a shape*/
		addShape();
		/*Create timer*/
		timer = new Timer(TIMER_SPEED, this);
		/*Start the timer*/
		timer.start();
	}

	//Testing
	/**
	 * If a row is full, passes that row to a method
	 * that removes the row
	 */
	private void rowFull()
	{
		int[] full = new int[shape.getBlocks().get(0).getNumRows()+1];
		
		for(int i=0;i<full.length;i++)
		{
			for(Block fall : fallen)
			{
				if(fall.getRow() == i && fall.isVisible()) full[i]++;
			}
			if(full[i] >= 12)
			{
				removeRow(i);
			}
		}
	}
	
	//Action
	/**
	 * Adds a block to the list of fallen blocks
	 * and adds a new block to the board
	 * */
	private void addShape()
	{
		int rand = new Random().nextInt(7);
		switch(rand)
		{
			case 0: shape = new Shape(xSize, ySize, Tetriminos.I);break;
			case 1: shape = new Shape(xSize, ySize, Tetriminos.J);break;
			case 2: shape = new Shape(xSize, ySize, Tetriminos.L);break;
			case 3: shape = new Shape(xSize, ySize, Tetriminos.O);break;
			case 4: shape = new Shape(xSize, ySize, Tetriminos.S);break;
			case 5: shape = new Shape(xSize, ySize, Tetriminos.T);break;
			case 6: shape = new Shape(xSize, ySize, Tetriminos.Z);break;
			default:break;
		}
	}

	/**
	 * Removes a row and all the blocks above it
	 * @param i
	 */
	private void removeRow(int i)
	{
		//Set blocks in that row invisible
		for(Block fall : fallen)
		{
			if(fall.getRow() == i) fall.setVisible(false);
		}
				

		for(Block fall : fallen)
		{
			if(fall.getRow()<i && fall.isVisible()) fall.setRow(fall.getRow()+1);
		}
	}
		
	/**
	 * Paints graphics to board.
	 * Called by using 'repaint()'
	 */
	@Override
	public void paint(Graphics g)
	{
		//Pass g to super class
		super.paint(g);
		
		//Type cast to 2D graphics
		Graphics2D g2d = (Graphics2D)g;
		
		//Paint falling block
		for(Block falli : shape.getBlocks())
		{
			g2d.setColor(falli.getColour());
			g2d.fillRect(falli.getColumn()*falli.getSize()+GAP, falli.getRow()*falli.getSize()+GAP, 
					falli.getSize()-GAP, falli.getSize()-GAP);
		}

		
		//Paint fallen blocks
		for(Block fall : fallen)
		{
			if(fall.isVisible())
			{
				g2d.setColor(fall.getColour());
				g2d.fillRect(fall.getColumn()*fall.getSize()+GAP, fall.getRow()*fall.getSize()+GAP, 
						fall.getSize()-GAP, fall.getSize()-GAP);	
			}
		}
	}
	
	/**
	 * This method is called by the Swing timer at
	 * TIMER_SPEED millisecond intervals
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//Check if row full
		rowFull();
		
		//Check if shape still falling, if not add a new one
		if(shape.hasStoopedFalling())
		{
			for(Block block : shape.getBlocks())
			{
				fallen.add(block);
			}
			addShape();
		}
		
		//Increment counter
		counter++;
		
		//Default fall
		if(counter%FALL_INTERVAL == 0) shape.move(Direction.DOWN, fallen);
		
		//Paint the screen
		repaint();
	}
	
	//Nested private class
	/**
	 * This class is used as a key listener for
	 * the board class.
	 * @author Liam A Doherty
	 * @version 3.12.12
	 */
	private class KAdapter extends KeyAdapter
	{
		/**
		 * Called as soon as key is pressed
		 */
		@Override
		public void keyPressed(KeyEvent e)
		{
			int id = e.getKeyCode();
			if(id == KeyEvent.VK_DOWN) shape.move(Direction.DOWN, fallen);
			if(id == KeyEvent.VK_LEFT) shape.move(Direction.LEFT, fallen);
			if(id == KeyEvent.VK_RIGHT) shape.move(Direction.RIGHT, fallen);
			if(id == KeyEvent.VK_UP) shape = new Geometry().rotate(shape);
		}
		
		/**
		 * Called as soon as a key is released
		 */
		@Override
		public void keyReleased(KeyEvent e)
		{
			
		}
	}
}
