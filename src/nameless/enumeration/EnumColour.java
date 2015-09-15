package nameless.enumeration;

public enum EnumColour
{
	RED('R', 255, 0, 0),
	ORANGE('O', 255, 128, 128),
	YELLOW('Y', 0, 255, 255),
	GREEN('G', 0, 255, 0),
	BLUE('B', 0, 0, 255),
	WHITE('W', 255, 255, 255);
	
	private final char symbol;
	private final int colourR;
	private final int colourG;
	private final int colourB;
	private final EnumColour opposite;
	
	EnumColour(char s, int R, int G, int B)
	{	
		symbol = s;
		colourR = R;
		colourG = G;
		colourB = B;
		opposite = this.getOppositeColour();
		
	}
	
	public EnumColour getOppositeColour()
	{
		switch(symbol)
		{
		case 'R': return EnumColour.ORANGE;
		case 'O': return EnumColour.RED;
		case 'Y': return EnumColour.GREEN;
		case 'G': return EnumColour.YELLOW;
		case 'B': return EnumColour.WHITE;
		case 'W': return EnumColour.BLUE;
		default: return EnumColour.RED;
		}
		
		
	}
	
	public int getColourR()
	{
		return colourR;
	}
	
	public int getColourG()
	{
		return colourG;
	}
	
	public int getColourB()
	{
		return colourB;
	}
}
