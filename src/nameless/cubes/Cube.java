//Ivan Ribeiro
//15/09/2015

package nameless.cubes;

public class Cube
{
    public int size;
    public MiniCube[][][] cube;

    //creates a minicube array with size s
    Cube(int s)
    {
        size = s;

        cube = new MiniCube[size][size][size];
        
        for (int i = 0; i<size; i++)
        {
        	for (int j = 0; j<size; i++)
        	{
        		for (int k = 0; k<size; k++)
        		{
        			
        		}
        	}
        }
    }


}
