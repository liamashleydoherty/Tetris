package game;

import java.awt.Color;
import java.util.ArrayList;
 
/**
 * Shape class. This class represents the different tetriminos in the game
 * @author Liam A Doherty
 * @version 0.2 18.12.12
 *
 */
public class Shape
{
	//Local static fields
	/*Start row of shape*/
	private static final int START_ROW = 5;
	
	//Local dynamic fields
	/*Array list of the different blocks that make up the shape*/
	private ArrayList<Block> blocks;
	/*Sets which block number to rotate the shape about*/
	private int rotateAbout;
	/*Controls if the shape can be rotated or not*/
	private boolean canRotate = true;
	/*The colour of the shape*/
	private Color colour;
	/*Boolean value represents if the shape is falling*/
	private boolean stopped = false;
	/*Block has stopped moving left*/
	private boolean stoppedLeft = false;
	/*block has stopped moving rihgt*/
	private boolean stoppedRight = false;
	
	/**
	 * Shape class constructor. Takes paramters for the screen X and Y size
	 * and a tetrimino ID that controls the shape
	 * @param xSize
	 * @param ySize
	 * @param tetrimino
	 */
	public Shape(int xSize, int ySize, Tetriminos tetrimino)
	{
		//Instantiate local objects
		/*Array list of shape blocks*/
		blocks = new ArrayList<Block>();
		
		//Local block field used to make shapes
		Block block;
		
		//Constructs required Tetrimino
		switch(tetrimino)
		{
			case I:
				/*Shape colour*/
				colour = Color.BLUE;
				
				for(int i=0;i<4;i++)
				{
					block = new Block(xSize, ySize);
					block.setColour(colour);
					block.setColumn(START_ROW+i);
					/*Shape rotate point*/
					rotateAbout = 1;
					block.setRow(0);
					blocks.add(block);
				}
				break;
			case J:
				/*Shape colour*/
				colour = Color.CYAN;
				/*Shape rotate point*/
				rotateAbout = 3;
				
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW);
				block.setRow(0);
				blocks.add(block);
				
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW);
				block.setRow(1);
				blocks.add(block);
				
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW+1);
				block.setRow(1);
				blocks.add(block);
				
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW+2);
				block.setRow(1);
				blocks.add(block);
				break;
			case L:
				/*Shape colour*/
				colour = Color.CYAN;
				/*Shape rotate point*/
				rotateAbout = 3;
				
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW+2);
				block.setRow(0);
				blocks.add(block);
				
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW+2);
				block.setRow(1);
				blocks.add(block);
				
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW+1);
				block.setRow(1);
				blocks.add(block);
				
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW);
				block.setRow(1);
				blocks.add(block);
				break;
			case O:
				/*Shape colour*/
				colour = Color.YELLOW;
				/*Disable rotation*/
				canRotate = false;
				
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW);
				block.setRow(0);
				blocks.add(block);
				
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW+1);
				block.setRow(0);
				blocks.add(block);
				
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW);
				block.setRow(1);
				blocks.add(block);
				
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW+1);
				block.setRow(1);
				blocks.add(block);
				break;
			case S:
				/*Shape colour*/
				colour = Color.GREEN;
				/*Shape rotate point*/
				rotateAbout = 1;
				
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW+1);
				block.setRow(0);
				blocks.add(block);
				
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW+2);
				block.setRow(0);
				blocks.add(block);
				
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW);
				block.setRow(1);
				blocks.add(block);
				
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW+1);
				block.setRow(1);
				blocks.add(block);
				break;
			case T:
				/*Shape colour*/
				colour = Color.RED;
				/*Shape rotate point*/
				rotateAbout = 2;
								
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW);
				block.setRow(1);
				blocks.add(block);
				
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW+1);
				block.setRow(1);
				blocks.add(block);
				
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW+1);
				block.setRow(0);
				blocks.add(block);
				
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW+2);
				block.setRow(1);
				blocks.add(block);
				break;
			case Z:
				/*Shape colour*/
				colour = Color.GREEN;
				/*Shape rotate point*/
				rotateAbout = 1;
				
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW);
				block.setRow(0);
				blocks.add(block);
				
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW+1);
				block.setRow(0);
				blocks.add(block);
				
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW+1);
				block.setRow(1);
				blocks.add(block);
				
				block = new Block(xSize, ySize);
				block.setColour(colour);
				block.setColumn(START_ROW+2);
				block.setRow(1);
				blocks.add(block);
				break;
			default:break;
		}
	}
	
	//Action
	public void move(Direction direction, ArrayList<Block> fallen)
	{
		switch(direction)
		{
			case DOWN:
				//Down collision prevention
				for(Block block : blocks)
				{
					if(block.getRow() + 1 > block.getNumRows()) stopped = true;
				}
				
				for(Block fall : fallen)
				{
					for(Block block : blocks)
					{
						if(block.getRow() + 1 == fall.getRow()
							&& block.getColumn() == fall.getColumn()
							&& fall.isVisible()) 
							stopped = true;
					}
				}
				if(stopped) break;

				//If not move all blocks in shape down
				for(Block block : blocks)
				{
					block.setRow(block.getRow()+1);
				}
				break;
			case LEFT:
				//Left collision prevention
				for(Block block : blocks)
				{
					if(block.getColumn() -1 < 0) stoppedLeft = true;
				}
				
				for(Block fall : fallen)
				{
					for(Block block : blocks)
					{
						if(block.getColumn() - 1 == fall.getColumn()
								&& block.getRow() == fall.getRow()
								&& block.isVisible()) 
							stoppedLeft = true;
					}
				}
				if(stoppedLeft)
				{
					stoppedLeft = false;
					break;
				}

				//If not move all blocks in shape left
				for(Block block : blocks)
				{
					block.setColumn(block.getColumn()-1);
				}
				break;
			case RIGHT:
				//Left collision prevention
				for(Block block : blocks)
				{
					if(block.getColumn() +1 > block.getNumColums()) stoppedRight = true;
				}
				
				for(Block fall : fallen)
				{
					for(Block block : blocks)
					{
						if(block.getColumn() + 1 == fall.getColumn()
								&& block.getRow() == fall.getRow()
								&& block.isVisible()) 
							stoppedRight = true;
					}
				}
				if(stoppedRight)
				{
					stoppedRight = false;
					break;
				}

				//If not move all blocks in shape right
				for(Block block : blocks)
				{
					block.setColumn(block.getColumn()+1);
				}
				break;
			default:break;
		}
	}
	
	//Getters
	/**
	 * Returns the array list of blocks
	 * @return blocks
	 */
	public ArrayList<Block> getBlocks()
	{
		return this.blocks;
	}
	
	/**
	 * Returns the rotate about position
	 * @return rotateAbout
	 */
	public int getRotateAbout()
	{
		return this.rotateAbout;
	}
	
	/**
	 * Returns can rotate value
	 * @return canRotate
	 */
	public boolean isRotate()
	{
		return this.canRotate;
	}
	
	/**
	 * Returns if the shape has stopped falling
	 * @return stopped
	 */
	public boolean hasStoopedFalling()
	{
		return this.stopped;
	}
	
	//Setters
	/**
	 * Sets a new pattern of blocks for the shape
	 * @param blocks
	 */
	public void setBlocks(ArrayList<Block> blocks)
	{
		this.blocks = blocks;
	}
}
