package org.katastrofi.penultimate;

/**
 * Two dimensional whole number coordinates.
 */
class XYCoordinates implements Location<XYCoordinates> {

    private final int x, y;

    private XYCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static XYCoordinates coord(int x, int y) {
        return new XYCoordinates(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof XYCoordinates)) return false;

        XYCoordinates that = (XYCoordinates) o;

        if (x != that.x) return false;
        return y == that.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public XYCoordinates oneUnitTo(Direction direction) {
        switch (direction) {
            case EAST:
                return coord(x + 1, y);
            case WEST:
                return coord(x - 1, y);
            case NORTH:
                return coord(x, y + 1);
            case SOUTH:
                return coord(x, y - 1);
            case NORTHEAST:
                return coord(x + 1, y + 1);
            case SOUTHEAST:
                return coord(x + 1, y - 1);
            case SOUTHWEST:
                return coord(x - 1, y - 1);
            case NORTHWEST:
                return coord(x - 1, y + 1);
            default:
                return this;
        }
    }
}
