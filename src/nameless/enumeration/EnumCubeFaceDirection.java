package nameless.enumeration;

public enum EnumCubeFaceDirection
{
    UP(1),
    DOWN(2),
    NORTH(3),
    SOUTH(4),
    EAST(5),
    WEST(6);

    public int direction;

    EnumCubeFaceDirection(int d)
    {
        direction = d;
    }
}
