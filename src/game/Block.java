package game;

import java.awt.Color;

/**
 * Block class. Represents a block on the game board
 * @author Liam A Doherty
 * @version 0.5 18.12.12
 */
public class Block
{
	//Local final fields
	/*Block size*/
	private static final int SIZE = 20;
	/*Block start column*/
	private static final int START_COLUMN = 5;
	
	//Local dynamic fields
	/*Number of columns*/
	private int numColumns;
	/*Number of rows*/
	private int numRows;
	/*Current column of block*/
	private int column;
	/*Current row of block*/
	private int row;
	/*Size of block*/
	private int size;
	/*Direction of block*/
	private Direction direction;
	/*Visibility of block*/
	private boolean visible;
	/*Colour of block*/
	private Color colour;
	
	/**
	 * Block class constructor.
	 * Takes parameters for the x and y dimensions of the screen.
	 * This is to calculate how many columns and rows are on the
	 * game board.
	 * @param xSize
	 * @param ySize
	 */
	public Block(int xSize, int ySize)
	{
		//Instantiate local fields
		/*Set number of columns*/
		numColumns 	= xSize/SIZE;
		/*Set number of rows*/
		numRows 	= ySize/SIZE;
		/*Set current column*/
		column 		= START_COLUMN;
		/*Set current row*/
		row 		= 0;
		/*Set block size*/
		size 		= SIZE;
		/*Set default direction*/
		direction 	= Direction.NONE;
		/*Set default visibility*/
		visible 	= true;
		/*Set default colour*/
		colour = Color.WHITE;
	}
	
	//Action
	/** 
	 * Method to move the block
	*/
	public void move()
	{
		if(direction == Direction.DOWN)  row++;
		if(direction == Direction.LEFT)  column--;
		if(direction == Direction.RIGHT) column++;

	}

	
	//Getters
	/**
	 * Returns the number of columns 
	 * @return numColumns
	 */
	public int getNumColums()
	{
		return this.numColumns;
	}
	
	/**
	 * Returns the number of rows
	 * @return numRows
	 */
	public int getNumRows()
	{
		return this.numRows;
	}
	
	/**
	 * Returns the current column the block is in
	 * @return column
	 */
	public int getColumn()
	{
		return this.column;
	}
	
	/**
	 * Returns the current row the block is in
	 * @return row
	 */
	public int getRow()
	{
		return this.row;
	}
	
	/**
	 * Returns the size if the block
	 * @return size
	 */
	public int getSize()
	{
		return this.size;
	}
	
	/**
	 * Returns colour
	 * @return colour
	 */
	public Color getColour()
	{
		return this.colour;
	}
	
	/**
	 * Returns the size of the direction of the block
	 * @return direction
	 */
	public Direction getDirection()
	{
		return this.direction;
	}
	
	/**
	 * Returns the the visibility of the block
	 * @return visible
	 */
	public boolean isVisible()
	{
		return this.visible;
	}
		
	//Setters
	/**
	 * Sets the column of the block
	 * @param column
	 */
	public void setColumn(int column)
	{
		this.column = column;
	}
	
	/**
	 * Sets the row of the block
	 * @param row
	 */
	public void setRow(int row)
	{
		this.row = row;
	}
	
	/**
	 * Sets the direction of the block
	 * @param direction
	 */
	public void setDirection(Direction direction)
	{
		this.direction = direction;
	}
	
	/**
	 * Sets the visibility of the block
	 * @param visible
	 */
	public void setVisible(boolean visible)
	{
		this.visible = visible;
	}
	
	/**
	 * Sets colour of the block
	 * @param colour
	 */
	public void setColour(Color colour)
	{
		this.colour = colour;
	}
}
