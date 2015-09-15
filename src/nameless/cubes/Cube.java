//Ivan Ribeiro
//15/09/2015

package nameless.cubes;

public class Cube
{
    public int size;
    public MiniCube[][][] cube;

    Cube(int s)
    {
        size = s;

        cube = new MiniCube[size][size][size];

    }


}
