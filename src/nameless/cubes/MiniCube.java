package nameless.cubes;

import nameless.enumeration.EnumColour;

public class MiniCube
{
	public EnumColour[] cubeFaces;
	
	MiniCube(EnumColour c1)
	{
		cubeFaces = new EnumColour[6];
	}

	//1 is north, 2 south, 3 east, 4 west, 5 top, 6 bottom
	public EnumColour getFaceColour(int index)
	{
		return cubeFaces[index];
	}
	
	
}
