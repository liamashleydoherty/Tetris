package game;

import java.util.ArrayList;

public class Geometry
{
	
	public Shape rotate(Shape shape)
	{
		int rightMost = shape.getBlocks().get(0).getNumColums();
		int leftMost = 0;
		
		if(shape.isRotate())
		{
			ArrayList<Block> temp = new ArrayList<Block>();
			temp = shape.getBlocks();
			
			for(Block tem : temp)
			{
				int x = tem.getColumn() - temp.get(shape.getRotateAbout()).getColumn();
				int y = tem.getRow() - temp.get(shape.getRotateAbout()).getRow();
				
				tem.setColumn(temp.get(shape.getRotateAbout()).getColumn() + y);
				tem.setRow(temp.get(shape.getRotateAbout()).getRow() + (x*-1));
				
				if(tem.getColumn() < leftMost) leftMost = tem.getColumn();
				if(tem.getColumn() > rightMost) rightMost = tem.getColumn();
			}
			
			if(leftMost < 0)
			{
				for(Block tem : temp)
				{
					tem.setColumn(tem.getColumn() - leftMost);
				}
			}
			
			if(rightMost > shape.getBlocks().get(0).getNumColums())
			{
				for(Block tem : temp)
				{
					tem.setColumn(tem.getColumn() - (rightMost-tem.getNumColums()));
				}
			}
			
			shape.setBlocks(temp);
		}
		return shape;
	}
}
