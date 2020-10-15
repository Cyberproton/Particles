package me.cyberproton.particle;

public enum Direction {
    NORTH(0, -1),
    NORTH_EAST(1, -1),
    EAST(1, 0),
    SOUTH_EAST(1, 1),
    SOUTH(0, 1),
    SOUTH_WEST(-1, 1),
    WEST(-1, 0),
    NORTH_WEST(-1, -1)
    ;

    private final int x;
    private final int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Direction getOpposite(Direction direction) {
        switch (direction) {
            case NORTH:
                return SOUTH;
            case NORTH_EAST:
                return SOUTH_WEST;
            case EAST:
                return WEST;
            case SOUTH_EAST:
                return NORTH_WEST;
            case SOUTH:
                return NORTH;
            case SOUTH_WEST:
                return NORTH_EAST;
            case WEST:
                return EAST;
            case NORTH_WEST:
                return SOUTH_EAST;
        }
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
