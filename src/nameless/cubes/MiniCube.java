package nameless.cubes;

import nameless.enumeration.EnumColour;

public class MiniCube
{
	public EnumColour colour1;
	public EnumColour colour2;
	public EnumColour colour3;
	
	MiniCube(EnumColour c1)
	{
		colour1 = c1;
	}
	
	MiniCube(EnumColour c1, EnumColour c2)
	{
		colour1 = c1;
		colour2 = c2;
	}
	
	MiniCube(EnumColour c1, EnumColour c2, EnumColour c3)
	{
		colour1 = c1;
		colour2 = c2;
		colour3 = c3;
	}
	
	public int getCubeFaceNumber()
	{
		if (colour2 == null)
		{
			return 1;
		}
		else if(colour3 == null)
		{
			return 2;
		}
		else
		{
			return 3;
		}
	}
}
