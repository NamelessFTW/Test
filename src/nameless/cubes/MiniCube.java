package nameless.cubes;

import nameless.enumeration.EnumColour;
import nameless.enumeration.EnumCubeFaceDirection;

public class MiniCube
{
	public EnumColour[] cubeFaces;
	
	MiniCube(EnumColour c1)
	{
		cubeFaces = new EnumColour[6];
	}

	public EnumColour getFaceColour(int index)
	{
		return cubeFaces[index];
	}
}
