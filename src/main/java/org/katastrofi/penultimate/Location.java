package org.katastrofi.penultimate;

import static java.lang.String.format;


/**
 * Two dimensional whole number coordinates.
 */
class Location {

    private final int x, y;

    private Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Location coord(int x, int y) {
        return new Location(x, y);
    }

    int x() {
        return x;
    }

    int y() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;

        Location that = (Location) o;

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
        return format("(%s,%s)", x, y);
    }

    public Location oneUnitTo(Direction direction) {
        if (direction == null) {
            return this;
        }
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
